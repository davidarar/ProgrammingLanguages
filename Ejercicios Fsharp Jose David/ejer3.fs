let n_esimo n lista =
    let indices = [0 .. List.length lista - 1]
    match List.tryFind (fun (i, _) -> i = n) (List.zip indices lista) with
    | Some (_, elemento) -> elemento
    | None -> false

let resultado1 = n_esimo 2 [1; 2; 3; 4; 5]
let resultado2 = n_esimo 3 [1; 2; 3; 4; 5]
let resultado3 = n_esimo 6 [1; 2; 3; 4; 5]

printfn "Resultado 1: %A" resultado1
printfn "Resultado 2: %A" resultado2
printfn "Resultado 3: %A" resultado3
// en este codigo investigue y la verdad se me ha complicado 
// pero al final obtuve este resultado, he pasado algunos ratos modificandolo 
// ya que no corre.