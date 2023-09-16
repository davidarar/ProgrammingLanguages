type Laberinto = char[,] // Define el laberinto como una matriz de caracteres
type Posicion = int * int // Define una posición como un par de enteros (fila, columna)

// Función para verificar si una posición está dentro de los límites del laberinto
let esPosicionValida laberinto (fila, columna) =
    fila >= 0 && columna >= 0 &&
    fila < Array2D.length1 laberinto &&
    columna < Array2D.length2 laberinto &&
    laberinto.[fila, columna] <> '#'

// Función para encontrar la ruta en el laberinto utilizando DFS
let rec encontrarRutaDFS laberinto inicio objetivo =
    let fila, columna = inicio
    if inicio = objetivo then
        // Hemos llegado al objetivo, devolvemos la posición como ruta
        [inicio]
    elif not (esPosicionValida laberinto inicio) then
        // La posición no es válida, no continuamos por aquí
        []
    elif laberinto.[fila, columna] = 'X' then
        // Ya hemos visitado esta posición, no continuamos por aquí
        []
    else
        // Marcamos la posición actual como visitada
        laberinto.[fila, columna] <- 'X'

        // Exploramos las cuatro direcciones posibles en orden: arriba, derecha, abajo, izquierda
        let direcciones = [(fila - 1, columna); (fila, columna + 1); (fila + 1, columna); (fila, columna - 1)]
        let rutas = [for dir in direcciones do
                        yield! encontrarRutaDFS laberinto dir objetivo]

        // Si alguna de las rutas contiene el objetivo, agregamos la posición actual a la ruta
        match rutas |> List.tryFind (fun ruta -> List.contains objetivo ruta) with
        | Some ruta -> inicio :: ruta
        | None -> []

// Función para imprimir el laberinto con la ruta encontrada
let imprimirLaberintoConRuta laberinto ruta =
    for fila = 0 to Array2D.length1 laberinto - 1 do
        for columna = 0 to Array2D.length2 laberinto - 1 do
            let posicion = (fila, columna)
            if List.contains posicion ruta then
                printf "O"
            else
                printf "%c" laberinto.[fila, columna]
        printfn ""

// Ejemplo de uso
let laberinto : Laberinto = 
    [|  [|'S'; '.'; '.'; '#'; '#'; '.'; '.'; '#'; '.'; 'E'|];
        [|'#'; '#'; '.'; '#'; '#'; '#'; '.'; '#'; '.'; '#'|];
        [|'.'; '.'; '.'; '.'; '.'; '.'; '.'; '.'; '.'; '.'|];
        [|'#'; '#'; '#'; '#'; '.'; '#'; '#'; '#'; '#'; '.'|];
        [|'#'; '.'; '.'; '#'; '.'; '#'; '.'; '#'; '.'; '#'|];
        [|'#'; '#'; '.'; '#'; '.'; '#'; '.'; '#'; '.'; '#'|];
        [|'#'; '.'; '.'; '.'; '.'; '.'; '.'; '.'; '.'; '#'|];
        [|'#'; '#'; '#'; '#'; '#'; '#'; '#'; '#'; '.'; '#'|];
        [|'.'; '.'; '.'; '.'; '.'; '.'; '.'; '.'; '.'; '.'|];
        [|'.'; '#'; '#'; '#'; '#'; '#'; '#'; '#'; '#'; '.'|] |]

let inicio = (0, 0) // Posición de inicio
let objetivo = (9, 9) // Posición de objetivo

let ruta = encontrarRutaDFS laberinto inicio objetivo

if List.isEmpty ruta then
    printfn "No se encontró una ruta."
else
    printfn "Ruta encontrada:"
    imprimirLaberintoConRuta laberinto ruta
