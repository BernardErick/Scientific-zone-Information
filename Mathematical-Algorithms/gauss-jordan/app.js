const fileSelector = document.getElementById("file-selector");
 
fileSelector.addEventListener('change', function(event){
 
    let file = event.target.files[0];
 
    if(file){
 
        let reader = new FileReader(file);
 
        reader.onload = function(){
 
            let lines = reader.result.split('\n');
            let first = true;
            let matrix;
            console.log("Percorrendo arquivo txt, por favor aguarde...");
            for( let i = 0; i < lines.length; i++){
                if(!lines[i].startsWith('%') && lines[i] != ''){
                    let aux = lines[i].split(' ');
                    if(first){
                        matrix = new Matrix(parseInt(aux[0]), parseInt(aux[1]))
                        first = false;
                    } else {
                        matrix.set(parseInt(aux[0]), parseInt(aux[1]), parseInt(aux[2]))
                    }
                      
                }
            }
            console.log("Arquivo verificado e convertido! Por favor aguarde o gauss terminar...");
            let la = new LinearAlgebra();
            let start = Date.now();
            let c = la.solve(matrix);
            let stop = Date.now();
            let elapsedTime = stop - start;
            console.log(c);
            console.log("Tempo executado pelo gauss: "+ elapsedTime + " milisegundos");
            document.write(" Done!");
        }
 
        reader.readAsText(file);
 
    }
 
});

