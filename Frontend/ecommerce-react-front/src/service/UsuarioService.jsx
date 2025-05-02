import api from "../api/api";


export const usuarioService = {

    register: async (datosUsuario) => {
        try {
            const response = await api.post("/api/auth/registro", datosUsuario);
            return response.data;
        } catch (error) {
            console.log("Hubo un error al registrar al usuario", error);
            throw error;
        }
    },


    login: async (datosUsuario) => {
        try {
            const response = await api.post("/api/auth/login", datosUsuario);
            return response.data;
        } catch (error) {
            console.log("Hubo un error al iniciar sesión: Usuario o contraseña incorrecto", error);
            throw error;
        }
    },

    userEmail: async (datosUsuario) => {
        try {
            const response = await api.get(`users/userEmail`, datosUsuario);
            return response.data;
        } catch (error) {
            console.log("Hubo un error al obtener el usuario por email", error);
            throw error;
        }
    },



};

