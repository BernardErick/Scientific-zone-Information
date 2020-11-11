class Matrix{
    constructor(rows,cols,values){
        this.rows = rows;
        this.cols = cols;

        if(values == undefined){
            this.values = [];
            for(let i = 0; i < this.rows*this.cols;i++){
                this.values.push(0)
            }
        }
        else{
            if(values.length == this.rows * this.cols){
                this.values = values
            }
            else{
                throw "O array de valores é incompativel com o tamanho da matriz."
            }
        }
    }
    get(i,j){
        return this.values[this.getIndex(i,j)];
    }
    set(i,j,value){
        this.values[this.getIndex(i,j)] = value
    }
    getIndex(i,j){

        if(i < 1 || i > this.rows) throw "O indice da linha esta fora dos valores permitidos"
        if(j < 1 || j > this.cols) throw "O indice da coluna esta fora dos valores permitidos"
        return (j-1) + (i-1) * this.cols;
    }
    show(){
        let string = "";
        for(let i = 1; i <= this.rows; i++){
            string += "[ "
            for(let j = 1; j <= this.cols;j++){
                string += this.get(i,j) + " ";
            }
            string += "]"
            string += "\n"
        }
        console.log(string);
    }
}
 