package utez.edu.mx.Integradora8C.Filter;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import utez.edu.mx.Integradora8C.Entities.BitacoraDatos.BitacoraDatos;
import utez.edu.mx.Integradora8C.Entities.BitacoraDatos.BitacoraDatosRepository;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Component
public class BitacoraFilter extends OncePerRequestFilter {

    @Autowired
    private BitacoraDatosRepository bitacoraRepository;
    @Autowired
    private ObjectMapper ObjectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        MultiReadHttpServletRequest multiReadRequest = new MultiReadHttpServletRequest(request);
        MultiReadHttpServletResponse multiReadResponse = new MultiReadHttpServletResponse(response);
        filterChain.doFilter(multiReadRequest, multiReadResponse);
        String body = multiReadRequest.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
        String responseBody = new String(multiReadResponse.getContentAsByteArray(), response.getCharacterEncoding());
        ObjectNode jsonNode = ObjectMapper.createObjectNode();
        BitacoraDatos bitacora = new BitacoraDatos();
        String token = request.getHeader("Authorization");
        if (token != null) {
            token = token.replace("Bearer ", "");
        }
        bitacora.setMetodo(request.getMethod());
        bitacora.setRutaSolicitada(request.getRequestURI());
        bitacora.setIp(request.getRemoteAddr());
        bitacora.setAgenteUsuario(request.getHeader("User-Agent"));
        bitacora.setEstadoHttp(response.getStatus());
        jsonNode.put("token", token);
        try {
            jsonNode.set("cuerpo", ObjectMapper.readTree(body));
        } catch (JsonProcessingException e) {
            jsonNode.put("cuerpo", "JSON invalido");
        }
        // colocamos lo que le dio de response
        try {
            jsonNode.set("respuesta", ObjectMapper.readTree(responseBody));
        } catch (JsonProcessingException e) {
            jsonNode.put("respuesta", "JSON invalido");
        }
        JsonNode node = ObjectMapper.valueToTree(jsonNode);
        bitacora.setDatos(node);
        bitacora.setCreadoEn(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis())));
        multiReadResponse.copyBodyToResponse();
        try {
            if (request.getMethod().equals(HttpMethod.PUT.name()) || request.getMethod().equals(HttpMethod.POST.name()) || request.getMethod().equals(HttpMethod.DELETE.name())) {
                bitacoraRepository.save(bitacora);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
