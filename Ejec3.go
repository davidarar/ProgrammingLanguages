package main

import "fmt"

func rotateSequence(arr *[]interface{}, positions int, direction int) {
	length := len(*arr)
	if length == 0 {
		return
	}

	positions = positions % length

	if direction == 0 { // Rotación a la izquierda
		*arr = append((*arr)[positions:], (*arr)[:positions]...)
	} else if direction == 1 { // Rotación a la derecha
		*arr = append((*arr)[length-positions:], (*arr)[:length-positions]...)
	}
}

func main() {
	sequence := []interface{}{"a", "b", "c", "d", "e", "f", "g", "h"}
	fmt.Println("Secuencia Original:", sequence)

	rotations := []struct {
		positions int
		direction int
	}{
		{3, 0}, // Rotación a la izquierda
		{2, 1}, // Rotación a la derecha
	}

	for _, rotation := range rotations {
		rotatedSequence := make([]interface{}, len(sequence))
		copy(rotatedSequence, sequence)
		rotateSequence(&rotatedSequence, rotation.positions, rotation.direction)
		dir := "izq"
		if rotation.direction == 1 {
			dir = "der"
		}
		fmt.Printf("Secuencia final rotada %s = %v\n", dir, rotatedSequence)
	}
}
