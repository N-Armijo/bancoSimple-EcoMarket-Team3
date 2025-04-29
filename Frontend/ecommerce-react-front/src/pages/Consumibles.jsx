import React from "react";
import GridProducto from "../components/Producto/GridProducto";
import { useTheme } from "../Context/themeContext";


export default function Consumibles() {
    const { colors } = useTheme();

    return (
        <>  
        <section
            style={{
                backgroundColor: colors.background,
                minHeight: "100vh",
                display: "flex",
                flexDirection: "column"
            }}>

                <div
                    style={{
                        padding: "2rem",
                        flex: 1,
                        display: "flex",
                        flexDirection: "column"
                    }}
                >   
                    <h1
                        style={{
                            color: colors.primary,
                            textAlign: "center",
                            marginBottom: "2rem"
                        }}
                    >Productos alimenticios variados</h1>
                    <GridProducto categoria="consumibles"/>
                </div>
        </section>
            
        </>
    )
}