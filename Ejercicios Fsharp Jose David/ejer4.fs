/ Función principal de búsqueda en profundidad
let prof recipiente objetivo =
    let rec prof_aux ruta objetivo =
        if List.isEmpty ruta then []
        elif solucion (List.head (List.head ruta)) objetivo then
            List.rev (List.head ruta) //:: prof_aux ((extender (List.head ruta)) @ (List.tail ruta)) objetivo       
        else
            prof_aux ((extender (List.head ruta)) @ (List.tail ruta)) objetivo
    prof_aux [[recipiente]] objetivo 




//modificado


type Grafo = (string * int) list list

let extender grafo ruta =
    let nodoActual, _ = List.head ruta
    let vecinos = List.tryFind (fun (nodo, _) -> nodo = nodoActual) grafo
    match vecinos with
    | Some vecino -> vecino :: List.filter (fun (nodo, _) -> not (List.exists (fun (v, _) -> v = nodo) ruta)) grafo
    | None -> []

let rec busquedaProfundidad grafo objetivo =
    let rec dfs ruta =
        let nodoActual, pesoActual = List.head ruta
        if nodoActual = objetivo then
            ruta, pesoActual
        else
            let extensiones = extender grafo ruta
            let resultados = List.map (fun (nodo, peso) ->
                let nuevaRuta = (nodo, peso) :: ruta
                dfs nuevaRuta) extensiones
            let resultadoMinimo = resultados |> List.minBy snd
            resultadoMinimo

    let ruta, peso = dfs [("i", 0)]
    List.rev ruta, peso

let grafo = [["i", 0]; ["a", 3]; ["b", 6]; ["c", 5]; ["d", 2]; ["e", 7]]
let objetivo = "e"

let camino, peso = busquedaProfundidad grafo objetivo
printfn "Camino más corto: %A" (List.map fst camino)
printfn "Peso total: %d" peso