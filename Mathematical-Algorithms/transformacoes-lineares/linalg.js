class LinearAlgebra{
    //Cnxm = Cmxn
    transpose(a){
        let c;
        //Verificar se A é um Vetor
        if(a instanceof Vector){
            c = new Vector(a.size());
            c.rows = a.cols;
            c.cols = a.rows;
            for(let i = 1;i <= c.cols;i++){
                c.set(i,a.get(i));
            }
        }
        //verificar se A é uma matriz
        this.#isMatrix(a);
        //A é uma matriz então..
        c = new Matrix (a.cols,a.rows);
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
        this.#isMatrix(a);

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
        this.#isMatrix(b);

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
        this.#isMatrix(a);
        this.#isMatrix(b);
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
        this.#isMatrix(a);
        this.#isMatrix(b);
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
        this.#isMatrix(a);
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
        this.#isMatrix(a);
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
    this.#isMatrix(a);

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
        this.#isMatrix(a);
        //triangular inferior
        let c = this.eliminacaoGaussiana(a).matrix;
        //triangular superior
        this.retropropagacao(c);
        //diagonal principal
        this.ajuste(c);
        //Vector result
        var arrayResult = new Vector(c.rows);
        for(let i = 1;i <= arrayResult.size();i++){
            arrayResult.set(i,c.get(i,c.cols));
        }
        return arrayResult;

    }
    //Implementação de determinante
    det(a){
        let c = this.eliminacaoGaussiana(a);
        let det = c.cof;
        for(let i = 1; i <= c.matrix.rows;i++){
            det *= c.matrix.get(i,i);
        }
        return det;
    }
    //Implementação da matriz inversa
    inverse(a){
        //verificar se A é uma matriz
        this.#isMatrix(a);
        //verificar se A é quadratica
        this.#isSquare(a);
        //criar uma matrix que ja 'recebeu' o solve
        let m = this.#generateMatrixSolve(a);
        //criar uma nova matrix n x 2n
        let c = new Matrix(a.rows,a.rows*2);
        //preencher a matrix c com os valores de 'a'
        for(let i = 1; i <= a.rows;i++){
            for(let j = 1;j <= a.cols;j++){
                c.set(i,j,a.get(i,j));
            }
        }
        //preencher a matrix c com os valores de 'm'
        for(let i = 1; i <= m.rows;i++){
            for(let j = 1;j <= m.cols;j++){
                //pegando a quantidade de linhas de m e a quantidade de colunas de 'a' somado a quantas colunas 'm' possui
                c.set(i,a.cols+j,m.get(i,j));
            }
        }
        //meter o solve
        //detalhe que não pude mandar o solve original por conta que ele retorna um vetor
        let d = this.eliminacaoGaussiana(c);
        this.retropropagacao(d.matrix);
        this.ajuste(d.matrix);

        //criei uma variavel pra jogar a parte que eu quero retornar
        let inverse = new Matrix(a.rows,a.cols);

        for(let i = 1; i <= inverse.rows;i++){
            for(let j = 1; j <= inverse.cols; j++){
                inverse.set(i,j,d.matrix.get(i,a.cols+j));
            }
        }


        return inverse;
    }
    eliminacaoGaussiana(a){
        this.#isMatrix(a);
        this.#matrixHasGaussCompability(a);
        //objeto com a matriz e seu respectivo coeficiente
        let c = {
            matrix: new Matrix(a.rows,a.cols,a.values.slice()),
            cof: 1
        }
        
        for(let j = 1; j <= c.matrix.rows; j++){
            for(let i = j + 1; i <= c.matrix.rows; i++){
                if(c.matrix.get(i,j) == 0){
                    continue;
                }
                if(c.matrix.get(j,j) == 0){
                    for(let k = j + 1; k <= c.matrix.rows;k++){
                        if(c.matrix.get(k,j) != 0){
                            this.switchLine(j,k,c.matrix);
                            c.cof *= -1;
                            break;
                        }
                    }
                    continue;
                }
                var k = this.#resultK(c.matrix.get(j,j),c.matrix.get(i,j));
                this.timesKsum(k,j,i,c.matrix);               
            }
        }
        return c;
    }
    retropropagacao(c){
        for(let j = c.rows; j >= 2; j--){
            for(let i = j-1; i >= 1;i--){
                if(c.get(i,j) == 0){
                    continue;
                }
                var k = this.#resultK(c.get(j,j),c.get(i,j));
                this.timesKsum(k,j,i,c);  
            }
        }
    }
    ajuste(c){
        for(let j = 1;j <= c.rows;j++){
            if(c.get(j,j) != 1){
                var k = 1/c.get(j,j);
                this.multLine(k,j,c);
            }
        }
    }

    #matrixHasGaussCompability(a){
        if(a.cols < a.rows){
            throw "A matriz passada como parâmetro é incompatível!";
        }
    }
    #resultK(x,y){
        var k = (y * -1) / x
        return k;
    }
    #isMatrix(a){
        if(typeof a != "object" || !(a instanceof Matrix)){
            throw "O parâmetro deve ser uma matriz.";
        }
    }
    #isSquare(a){
        if(a.rows != a.cols){
            throw "A matriz não é quadratica."
        }
    }
    #generateMatrixSolve(a){
        let c = new Matrix(a.rows,a.cols)
        for(let i = 1;i <= a.rows;i++){
            c.set(i,i,1);
        }
        return c;
    }


    
}