class LinearAlgebra{
    //Cnxm = Cmxn
    transpose(a){
        //verificar se A é uma matriz
        if(typeof a != "object" || !(a instanceof Matrix)){
            throw "O parâmetro 'a' deve ser uma matriz.";
        }
        let c = new Matrix (a.cols,a.rows);
        for(let i = 1;i<= c.rows;i++){
            for(let j =1;j <= c.cols;j++){
                c.set(i,j,a.get(j,i));
            }
        }
        return c;
    }
    //Cmxn = Amxn + Bmxn
    plus(a,b){
        //verificar se A é uma matriz
        if(typeof a !="object" || !(a instanceof Matrix) || typeof b !="object" || !(b instanceof Matrix) ){
            throw "Os parâmetros 'a' e 'b' devem ser uma matriz.";
        }
        if(a.rows != b.rows || a.cols != b.cols) throw "As matrizes são incompativeis"
        let c = new Matrix(a.rows, a.cols);
        for(let i = 1; i <= c.rows;i++){
            for(let j= 1; j <= c.cols;j++){
                c.set(i,j,a.get(i,j)+b.get(i,j));
            }
        }
        return c;
    }

    //Cmxn = Amxn * Bmxn ou Cmxn = k * Bmxn
    //times funciona como scalarMult(k * A) e times(A * B)!
    times(a,b){
        //verificar se B é uma matriz
        if(typeof b != "object" || !(b instanceof Matrix)){
            throw "O parâmetro 'b' deve ser uma matriz.";
        }

        let c = new Matrix(b.rows, b.cols);
        //se for numero entao é K * Amxn
        if(typeof a == "number"){
            for(let i = 1;i<= c.rows;i++){
                for(let j= 1;j<= c.cols;j++){
                    c.set(i,j,a * b.get(i,j));
                }
            }
        }
        //se for objeto entao deve verificar se ele é uma Matriz
        else if(typeof a == "object" && a instanceof Matrix){
            
            if(a.rows != b.rows || a.cols != b.cols) throw "As matrizes são incompatíveis.";

            for(let i = 1; i <= c.rows; i++){
                for(let j = 1; j <= c.cols;j++){
                    c.set(i,j,a.get(i,j) * b.get(i,j))
                }
            }
        }
        else{
            throw "O parâmetro 'a' deve ser um escalar numérico ou uma matriz.";
        }

        return c;
    }
    //Cmxn = Amxn / Bmxn
    div(a,b){
        //verificar se a e b são matrizes
        if(typeof a !="object" || !(a instanceof Matrix) || typeof b !="object" || !(b instanceof Matrix) ){
            throw "Os parâmetros a e b deve ser uma matriz"
        }
        //Verificar  se as matrizes possuem o mesmo tamanho
        if(a.rows != b.rows || a.cols != b.cols){
            throw "As matrizes são incompativeis."
        }
        //Verificar se a matriz b possui algum elemento nulo
        for(let i = 0; i< b.values.length;i++){
            if(b.values[i] == 0){
                throw "A matriz b possui pelo menos um elemento nulo."
            }
        }
        let c = new Matrix(a.rows, a.cols);
        for(let i = 1;i<= c.rows;i++){
            for(let j= 1;j<= c.cols;j++){
                c.set(i,j,a.get(i,j) / b.get(i,j));
            }
        }
        return c;
    }
    dot(a,b){
        //verificar se a e b são matrizes
        if(typeof a !="object" || !(a instanceof Matrix) || typeof b !="object" || !(b instanceof Matrix) ){
            throw "Os parâmetros a e b deve ser uma matriz"
        }
        //verificar se o número de colunas de A são iguais as colunas de B
        if(a.cols != b.rows){
            throw "As colunas de 'A' precisam ter a mesma quantidade das linhas de 'B' "
        }
        let c = new Matrix(a.rows,b.cols);
        for(let i = 1; i <= a.rows;i++){
            for(let j = 1; j <= b.cols;j++){
                for(let k = 1; k <= b.rows;k++){
                    c.set(i,j,c.get(i,j) + a.get(i,k) * b.get(k,j));
                }
            }
        }
        return c;
    }
    //--------------------------------OPERAÇÕES COM AS LINHAS---------------------------------

    //---------------------------- multiplicar uma constante por uma linha----------------------
    multLine(k,p,a){
        //verificar se a constante é nula ou não é um numero
        if(typeof k != "number" || k == 0) throw "A constante precisa ser um número valido!"
        //verificar se a posição é valida
        if(p < 1 || p > a.rows){
            throw "A posição da linha não existe na matriz!"
        } 
        //verificar se A é uma matriz
        if(typeof a !="object" || !(a instanceof Matrix) ){
            throw "O parâmetro 'a' deve ser uma matriz"
        }
        for(let i = 1; i <= a.rows;i++){
            for(let j = 1; j<= a.cols;j++){
                if(i == p){
                    a.set(i,j,a.get(i,j) * k)
                }
            }
        }
    }
    //---------------------------- trocar uma linha por outra  ----------------------
    switchLine(p1,p2,a){
        //verificar se as posições são validas
        if(p1 < 1 || p1 > a.rows || p2 < 1 || p2 > a.rows){
            throw "A posição das linhas escolhidas não existem na matriz!"
        }
        //verificar se são as mesmas posições
        if(p2 == p1){
            throw "mesmas posições! Não precisam ser trocadas!"
        }
        //verificar se 'a' é uma matriz
        if(typeof a != "object" || !(a instanceof Matrix)){
            throw "O parâmetro 'a' deve ser uma matriz"
        }
        for(let j = 1;j<= a.cols;j++){
            var aux = a.get(p1,j);
            a.set(p1,j,a.get(p2,j));
            a.set(p2,j,aux);
        }

    }
    //--------------------- somar uma (constante x linha) com outra linha ------------------
    timesKsum(k,p1,p2,a){
    //verificar se a constante é nula ou não é um numero
    if(typeof k != "number" || k == 0) throw "A constante precisa ser um número valido!"
    //verificar se a posição é valida
    if(p1 < 1 || p1 > a.rows || p2 < 1 || p2 > a.rows){
        throw "A posição da linha não existe na matriz!"
    } 
    //verificar se A é uma matriz
    if(typeof a !="object" || !(a instanceof Matrix) ){
        throw "O parâmetro 'a' deve ser uma matriz"
    }
    for(let i = 1; i <= p2; i++){
        if(i == p2){
            for(let j = 1; j <= a.cols; j++){
                a.set(i,j,a.get(i,j) + (a.get(p1,j) * k));
            }
        }
    }

    }
    //--------------------- IMPLEMENTAÇÃO GAUSS- JORDAN -------------------------------
    solve(a){
        //verificar se A é uma matriz
        if(typeof a != "object" || !(a instanceof Matrix)){
            throw "O parâmetro 'a' deve ser uma matriz.";
        }
        let c = new Matrix(a.rows,a.cols,a.values.slice());
        console.log("0% do gauss-jordan concluido!");
        //triangular inferior
        for(let j = 1; j <= c.cols -2; j++){
            for(let i = j + 1; i <= c.rows; i++){
                if(c.get(i,j) == 0){
                    continue;
                }
                if(c.get(j,j) == 0){
                    this.switchLine(j,i,c);
                    continue;
                }
                var k = this.resultK(c.get(j,j),c.get(i,j));
                this.timesKsum(k,j,i,c);               
            }
        }
        console.log("25% do gauss-jordan concluido!");
        //triangular superior
        for(let j = c.cols-1; j >= 2; j--){
            for(let i = j-1; i >= 1;i--){
                if(c.get(i,j) == 0){
                    continue;
                }
                if(c.get(j,j) == 0){
                    this.switchLine(j,i,c);
                    continue;
                }
                var k = this.resultK(c.get(j,j),c.get(i,j));
                //c = this.newTimes2(k,j,i,c); 
                this.timesKsum(k,j,i,c);  
            }
        }
        console.log("50% do gauss-jordan concluido!")
        //diagonal principal
        for(let j = 1;j <= c.cols - 1;j++){
            if(c.get(j,j) != 1){
                var k = 1/c.get(j,j);
                this.multLine(k,j,c);
            }
        }
        console.log("75% do gauss-jordan concluido!")
        //Vector result
        var arrayResult = new Vector(c.rows);
        for(let i = 1;i <= c.rows;i++){
            arrayResult.values[i-1] = c.get(i,c.cols);
        }
        console.log("100% do gauss-jordan concluido!")
        return arrayResult;

    }
    resultK(x,y){
        var k = (y * -1) / x
        return k;
    }

   


    
}