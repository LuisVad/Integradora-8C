import VueRouter from "vue-router";
import Vue from "vue";
import Error404 from "../views/ErrorPages/Error404.vue";
import Login from "../views/Login.vue";
import CreateCount from "../views/CreateCount.vue";
import RecoverPasssword from "../views/RecoverPassword.vue";  

Vue.use(VueRouter);
const routes = [
  //la ruta base
  {
    path: "/",
  },
  {
    path: "/",
    component: {
      render(c) {
        return c("router-view");
      },
    },
    children: [
      {
        path: "/login",
        name: "login",
        component: Login,
      },
      {
        path: "/404",
        name: "404",
        component: Error404,
      },
      {
        path: "/createcount",
        name: "createcount",
        component: CreateCount,
      },
      {
        path: "/recoverpassword",
        name: "recoverpassword",
        component: RecoverPasssword,
      },
      {
        path: "*",
        redirect: "/404",
      },
    ],
  },
];
const router = new VueRouter({ routes });
export default router;
