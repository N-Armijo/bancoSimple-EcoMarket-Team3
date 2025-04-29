import './App.css'
import Nosotros from './components/Nosotros/Nosotros.jsx'
import Navbar from './components/Navbar/Navbar.jsx'
import { ThemeProvider } from './Context/themeContext.jsx';
import Footer from './components/Footer/Footer.jsx';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Electrodomesticos from './pages/Electrodomesticos.jsx';
import Prendas from './pages/Prendas.jsx';
import Consumibles from './pages/Consumibles.jsx';


function App() {
  // const handleAgregar = (producto) => {
  //   console.log("Agregado:", producto);
  // };

  return (
    <>
    
    <ThemeProvider>
      <div className="App">
        <Navbar />
        <div className="content">
          <Routes>
            <Route path="/electrodomesticos" element={<Electrodomesticos />} />
            <Route path="/prendas" element={<Prendas />} />
            <Route path="/consumibles" element={<Consumibles />} />
            <Route path="/nosotros" element={<Nosotros />} />
          </Routes>
        </div>
        <Footer />
      </div>
    </ThemeProvider>
      
    </>
  );
}

export default App;

