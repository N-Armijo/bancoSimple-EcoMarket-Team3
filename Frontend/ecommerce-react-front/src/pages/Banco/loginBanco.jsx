import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Box, Typography, TextField, Button, Link } from "@mui/material";
import logo from "../../assets/logo.jpeg"; // Asegúrate de que el logo esté en esta ruta

const LoginBanco = ({ setIsLoggedIn }) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();

    // Simulación de autenticación
    if (email === "usuario@banco.com" && password === "123456") {
      setIsLoggedIn(true); // Cambia el estado de inicio de sesión
      navigate("/bancoSimple"); // Redirige a la página principal del banco
    } else {
      setError("Correo o contraseña incorrectos.");
    }
  };

  return (
    <Box sx={{ display: "flex", height: "100vh", backgroundColor: "#f5f5dc" }}>
      {/* Sidebar */}
      <Box
        sx={{
          width: "20%",
          backgroundColor: "#4caf50",
          display: "flex",
          flexDirection: "column",
          justifyContent: "space-between",
          alignItems: "center",
          padding: "2rem 1rem",
        }}
      >
        {/* Logo */}
        <Box sx={{ marginBottom: "2rem" }}>
          <img src={logo} alt="Logo BancoSimple" style={{ width: "200px" }} />
        </Box>

        {/* Footer Links */}
        <Box sx={{ textAlign: "center", width: "100%" }}>
          <Box sx={{ display: "flex", justifyContent: "space-around", marginBottom: "1rem" }}>
            <Link href="#" underline="hover" sx={{ color: "#000000", fontWeight: "bold" }}>
              Nosotros
            </Link>
            <Link href="#" underline="hover" sx={{ color: "#000000", fontWeight: "bold" }}>
              Contacto
            </Link>
          </Box>
          <Typography variant="body2" sx={{ color: "#000000" }}>
            © 2025 BancoSimple
          </Typography>
        </Box>
      </Box>

      {/* Main Content */}
      <Box
        sx={{
          flex: 1,
          display: "flex",
          flexDirection: "column",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <Typography variant="h4" sx={{ marginBottom: "2rem" }}>
          Iniciar Sesión - BancoSimple
        </Typography>
        <form onSubmit={handleLogin} style={{ width: "300px" }}>
          <TextField
            label="Correo electrónico"
            type="email"
            fullWidth
            required
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            sx={{ marginBottom: "1rem" }}
          />
          <TextField
            label="Contraseña"
            type="password"
            fullWidth
            required
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            sx={{ marginBottom: "1rem" }}
          />
          {error && (
            <Typography color="error" sx={{ marginBottom: "1rem" }}>
              {error}
            </Typography>
          )}
          <Button type="submit" variant="contained" fullWidth sx={{ backgroundColor: "#4caf50" }}>
            Iniciar Sesión
          </Button>
        </form>
        <Typography sx={{ marginTop: "1rem" }}>
          ¿No tienes cuenta?{" "}
          <Link href="/bancoSimple/registerBanco" sx={{ color: "#4caf50", fontWeight: "bold" }}>
            Regístrate aquí
          </Link>
        </Typography>
      </Box>
    </Box>
  );
};

export default LoginBanco;