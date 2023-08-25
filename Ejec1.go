package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	fmt.Println("Ingresa el texto:")
	text := readText()

	charCount := countCharacters(text)
	wordCount := countWords(text)
	lineCount := countLines(text)

	fmt.Printf("Número de caracteres: %d\n", charCount)
	fmt.Printf("Número de palabras: %d\n", wordCount)
	fmt.Printf("Número de líneas: %d\n", lineCount)
}

func readText() string {
	scanner := bufio.NewScanner(os.Stdin)
	text := ""

	for scanner.Scan() {
		line := scanner.Text()
		if line == "" {
			break
		}
		text += line + "\n"
	}

	return text
}

func countCharacters(text string) int {
	return len(text)
}

func countWords(text string) int {
	words := strings.Fields(text)
	return len(words)
}

func countLines(text string) int {
	lines := strings.Split(text, "\n")
	return len(lines)
}
