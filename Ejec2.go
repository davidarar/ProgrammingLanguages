package main

import "fmt"

func main() {
	size := 7 // Tamaño del rombo (debe ser un número impar)
	printDiamond(size)
}

func printDiamond(size int) {
	if size%2 == 0 {
		size++ // Asegurarse de que el tamaño sea impar
	}

	for i := 0; i < size; i++ {
		spaces := abs(size/2 - i)
		stars := size - 2*spaces

		for j := 0; j < spaces; j++ {
			fmt.Print(" ")
		}
		for j := 0; j < stars; j++ {
			fmt.Print("*")
		}
		fmt.Println()
	}
}

func abs(num int) int {
	if num < 0 {
		return -num
	}
	return num
}
