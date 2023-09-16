let desplazarLista direccion n lista =
    let longitud = List.length lista
    let desplazamiento = n % longitud
    match direccion with
    | "izq" ->
        if longitud = 0 then
            []
        else
            List.take longitud (List.skip desplazamiento lista @ List.take desplazamiento lista)
    | "der" ->
        if longitud = 0 then
            []
        else
            List.take longitud (List.skip (longitud - desplazamiento) lista @ List.take (longitud - desplazamiento) lista)
    | _ -> failwith "Dirección no válida"

let listaDesplazadaIzquierda = desplazarLista "izq" 3 [1; 2; 3; 4; 5]
let listaDesplazadaDerecha = desplazarLista "der" 2 [1; 2; 3; 4; 5]
let listaDesplazadaIzquierdaExceso = desplazarLista "izq" 6 [1; 2; 3; 4; 5]

printfn "Lista desplazada a la izquierda: %A" listaDesplazadaIzquierda
printfn "Lista desplazada a la derecha: %A" listaDesplazadaDerecha
//lista con un desplazamiento mayor que la longitud Original
printfn "Lista desplazada a la izquierda con exceso: %A" listaDesplazadaIzquierdaExceso
