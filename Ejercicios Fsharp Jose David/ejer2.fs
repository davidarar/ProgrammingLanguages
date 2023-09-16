let subCadenas subcadena lista =
    List.filter (fun cadena -> cadena.Contains subcadena) lista

let resultado = subCadenas "la" ["la casa"; "el perro"; "pintando la cerca"]

printfn "Cadenas filtradas: %A" resultado
