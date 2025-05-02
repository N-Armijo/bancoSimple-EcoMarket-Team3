import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Box, Typography, TextField, Button, Link } from "@mui/material";
import logo from "../../assets/logo.jpeg"; // Asegúrate de que el logo esté en esta ruta

const RegisterBanco = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleRegister = (e) => {
    e.preventDefault();

    if (password !== confirmPassword) {
      setError("Las contraseñas no coinciden.");
      return;
    }

    // Simulación de registro
    console.log("Usuario registrado:", { email, password });
    navigate("/bancoSimple/loginBanco"); // Redirige al inicio de sesión
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
          Registro - BancoSimple
        </Typography>
        <form onSubmit={handleRegister} style={{ width: "300px" }}>
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
          <TextField
            label="Confirmar contraseña"
            type="password"
            fullWidth
            required
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            sx={{ marginBottom: "1rem" }}
          />
          {error && (
            <Typography color="error" sx={{ marginBottom: "1rem" }}>
              {error}
            </Typography>
          )}
          <Button type="submit" variant="contained" fullWidth sx={{ backgroundColor: "#4caf50" }}>
            Registrarse
          </Button>
        </form>
        <Typography sx={{ marginTop: "1rem" }}>
          ¿Ya tienes cuenta?{" "}
          <Link href="/bancoSimple/loginBanco" sx={{ color: "#4caf50", fontWeight: "bold" }}>
            Inicia sesión aquí
          </Link>
        </Typography>
      </Box>
    </Box>
  );
};

export default RegisterBanco;