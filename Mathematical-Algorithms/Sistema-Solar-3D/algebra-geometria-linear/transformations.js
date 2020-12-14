
class Transformations extends LinearAlgebra{
    /*
        Os metodos abaixo são utilizando a mesma logica de montagem, primeiro o vetor é convertido
        Em coordenada homogenea, depois é criado uma matriz baseada no seu novo tamanho, em seguida
        eu coloco o respetivo valor/mudança que ele precisa pra se comportar como seu respetivo metodo,
        multiplico os dois usando o DOT e depois desconverte para coordenada cartesiana e é enviado. 
        exemplo: Na reflexão adiciono -1 nos eixos que precisam para ocorrer o fenomeno.
        PS: como a multiplicação por dot retorna uma matriz, eu fiz uma conversão para que o resultado volte
        como um vetor.
    */
    //TODAS AS VARIAÇÕES DE REFLEXÃO ----------------------------------------------------
    reflection2Dx(vector){
        this.#isVector(vector);
        this.#is2dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(2,2,-1);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }    
    reflection2Dy(vector){
        this.#isVector(vector);
        this.#is2dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(1,1,-1);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    reflection3Dx(vector){
        this.#isVector(vector);
        this.#is3dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(3,3,-1);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    reflection3Dy(vector){
        this.#isVector(vector);
        this.#is3dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(1,1,-1);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    reflection3Dz(vector){
        this.#isVector(vector);
        this.#is3dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(2,2,-1);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    //TODAS AS VARIAÇÕES DE PROJEÇÃO ----------------------------------------------------
    projection2Dx(vector){
        this.#isVector(vector);
        this.#is2dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(2,2,0);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    projection2Dy(vector){
        this.#isVector(vector);
        this.#is2dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(1,1,0);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    projection3Dx(vector){
        this.#isVector(vector);
        this.#is3dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(3,3,0);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    projection3Dy(vector){
        this.#isVector(vector);
        this.#is3dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(1,1,0);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    projection3Dz(vector){
        this.#isVector(vector);
        this.#is3dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(2,2,0);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    //TODAS AS VARIAÇÕES DE ROTAÇÃO -------------------------------------------------------
    rotation2D(vector,angle){
        this.#isVector(vector);
        this.#is2dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(1,1,Math.cos(angle));
        t.set(1,2,Math.sin(angle) * -1);
        t.set(2,1,Math.sin(angle));
        t.set(2,2,Math.cos(angle));
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }

    rotation3D(vector,angle){
        this.#isVector(vector);
        this.#is3dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(1,1,Math.cos(angle));
        t.set(1,2,Math.sin(angle) * -1);
        t.set(2,1,Math.sin(angle));
        t.set(2,2,Math.cos(angle));
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    rotation3Dx(vector,angle){
        this.#isVector(vector);
        this.#is3dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(2,2,Math.cos(angle));
        t.set(3,2,Math.sin(angle));
        t.set(2,3,Math.sin(angle)* -1);
        t.set(3,3,Math.cos(angle));
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    rotation3Dy(vector,angle){
        this.#isVector(vector);
        this.#is3dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(1,1,Math.cos(angle));
        t.set(3,1,Math.sin(angle)* -1);
        t.set(1,3,Math.sin(angle));
        t.set(3,3,Math.cos(angle));
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    rotation3Dz(vector,angle){
        this.#isVector(vector);
        this.#is3dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(1,1,Math.cos(angle));
        t.set(2,1,Math.sin(angle));
        t.set(1,2,Math.sin(angle)* -1);
        t.set(2,2,Math.cos(angle));
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    //TODAS AS VARIAÇÕES DO ESCALONAMENTO
    scale2Dx(vector,value){
        this.#isVector(vector);
        this.#is2dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(1,1,value);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    scale2Dy(vector,value){
        this.#isVector(vector);
        this.#is2dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(2,2,value);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    scale3Dx(vector,value){
        this.#isVector(vector);
        this.#is3dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(3,3,value);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    scale3Dy(vector,value){
        this.#isVector(vector);
        this.#is3dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(1,1,value);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    scale3Dz(vector,value){
        this.#isVector(vector);
        this.#is3dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(2,2,value);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    //TODAS AS VARIAÇÕES DE CISALHAMENTO
    shearingx(vector,value){
        this.#isVector(vector);
        this.#is2dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(1,2,value);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    shearingy(vector,value){
        this.#isVector(vector);
        this.#is2dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(2,1,value);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    //TODAS AS VARIAÇÕES DE TRANSLAÇÃO
    translate2D(vector,dx,dy){
        this.#isVector(vector);
        this.#is2dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(1,3,dx);
        t.set(2,3,dy);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    translate3D(vector,dx,dy,dz){
        this.#isVector(vector);
        this.#is3dVector(vector);
        vector = this.#coordenadaHomogenea(vector);
        let t = this.#generateMatrixZeroOne(new Matrix(vector.size(),vector.size()));
        t.set(1,4,dx);
        t.set(2,4,dy);
        t.set(3,4,dz);
        return this.#coordenadaCartesiana(this.#convertMatrixToVector(this.dot(t,vector)));
    }
    #isVector(vector){
        if(typeof vector != "object" || !(vector instanceof Vector)){
            throw "O parâmetro deve ser um vetor.";
        }
    }
    #is2dVector(vector){
        if(vector.size()!=2) throw "O vetor precisa ser de 2 dimenções";
    }
    #is3dVector(vector){
        if(vector.size()!=3) throw "O vetor precisa ser de 3 dimenções";
    }
    //Metodo para converter qualquer vetor que esteja em Cartesiano em Homogeneo
    //1D -> 2D -> 3D -> 4D
    #coordenadaHomogenea(vector){
        let v = new Vector(vector.size()+1);
        for(var i = 1;i<= vector.size();i++){
            v.set(i,vector.get(i));
        }
        v.set(vector.size()+1,1);
        return v;
    }
    //Metodo para converter qualquer vetor que esteja em Homogeneo em Cartesiano
    //1D <- 2D <- 3D <- 4D
    #coordenadaCartesiana(vector){
        let v = new Vector(vector.size()-1);
        for(var i = 1;i<= v.size();i++){
            v.set(i,vector.get(i));
        }
        return v;
    }
    //converte matrix para vetor
    #convertMatrixToVector(a){
        let vector = new Vector(a.cols*a.rows,a.values.slice());
        for(let i = 1;i <= a.rows;i++){
            for(let j = 1;j<= a.cols;j++){
                vector.set(i,a.get(i,j));
            }
        }
        return vector;
    }
    //cria matriz estilo solve
    #generateMatrixZeroOne(a){
        let c = new Matrix(a.rows,a.cols)
        for(let i = 1;i <= a.rows;i++){
            c.set(i,i,1);
        }
        return c;
    }



}