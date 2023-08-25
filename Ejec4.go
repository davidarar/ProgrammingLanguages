package main

import (
	"fmt"
)

type Calzado struct {
	Modelo string
	Precio float64
	Talla  int
	Stock  int
}

func main() {
	inventario := []Calzado{
		{"Pioneer", 50000, 40, 10},
		{"Dior", 45000, 44, 5},
		{"Gucci", 40000, 35, 8},
		{"Prada", 55000, 38, 3},
		// Puedes agregar más zapatos aquí
	}

	fmt.Println("Inventario de la tienda de zapatos:")
	for _, zapato := range inventario {
		fmt.Printf("Modelo: %s, Precio: %.2f colones, Talla: %d, Stock: %d unidades\n",
			zapato.Modelo, zapato.Precio, zapato.Talla, zapato.Stock)
	}
}
