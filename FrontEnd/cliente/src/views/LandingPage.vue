<template>
  <div class="container">
    <header>
      <div class="carousel">
        <b-carousel
          id="carousel-1"
          v-model="slide"
          :interval="4000"
          controls
          indicators
          background="#ababab"
          style="text-shadow: 1px 1px 2px #333"
          @sliding-start="onSlideStart"
          @sliding-end="onSlideEnd"
        >
          <!-- Text slides with image -->
          <b-carousel-slide
            img-src="https://visitachihuahuacapital.com/wp-content/uploads/2023/06/restaurantes-buffet-chihuahua-1-1200x738.jpg.webp"
          ></b-carousel-slide>
          <b-carousel-slide
            img-src="https://visitachihuahuacapital.com/wp-content/uploads/2023/06/restaurentes-buffet-chihuahua-7-CUU-1200x738.jpg.webp"
          >
          </b-carousel-slide>
          <b-carousel-slide
            img-src="https://visitachihuahuacapital.com/wp-content/uploads/2023/06/restaurentes-buffet-chihuahua-7-CUU-1200x738.jpg.webp"
          ></b-carousel-slide>
        </b-carousel>
      </div>
    </header>
    <main>
      <div class="content">
        <h1>Foter Buffet</h1>
        <p>Disfruta de nuestro delicioso buffet de comida con una amplia variedad de platillos para satisfacer todos los gustos. Nuestro buffet incluye opciones vegetarianas, platos principales, ensaladas frescas, postres y mucho más. Ven y disfruta de una experiencia gastronómica única en nuestro restaurante.</p>
      </div>
    </main>
    <footer>
      <p>Derechos reservados</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: "LandingPage",
  data() {
    return {
      slide: 0,
      sliding: null,
    };
  },
  methods: {
    onSlideStart(slide) {
      this.sliding = true;
    },
    onSlideEnd(slide) {
      this.sliding = false;
    },
  },
};
</script>

<style scoped>
.carousel {
  margin-bottom: 20px;
  max-height: 480px;
  width: 1024px;
  overflow: hidden;
}

.carousel img {
  height: auto;
  width: 100%;
}

.container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: #ffffff;
  border-radius: 5px;
  padding: 20px;  
  width: 100%;
}

h1 {
  font-size: 24px;
  color: #000000;
}

p {
  font-size: 16px;
  color: #000000;
}

.link {
  display: block;
  margin-top: 16px;
  font-size: 16px;
  color: #000000;
}

footer {
  text-align: center;
  margin-top: 32px;
  font-size: 14px;
}
</style>
<style scoped></style>
