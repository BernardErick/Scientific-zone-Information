class Rectangle{
    constructor(x, y, w, h){
        this.points = [];
        this.points.push(new Vector(2, [x, y]));
        this.points.push(new Vector(2, [x + w, y]));
        this.points.push(new Vector(2, [x + w , y + h]));
        this.points.push(new Vector(2, [x, y + h]));

        this.color = '#ffffff';
        this.tr = new Transformations();
    }
    setColor(value){
        this.color = value;
    }
    draw(){
        beginShape(TRIANGLES);
        
        strokeWeight(1);
        stroke(this.color);
        fill(this.color);
        
        vertex(this.points[0].get(1),this.points[0].get(2));
        vertex(this.points[1].get(1),this.points[1].get(2));
        vertex(this.points[3].get(1),this.points[3].get(2));

        vertex(this.points[1].get(1),this.points[1].get(2));
        vertex(this.points[2].get(1),this.points[2].get(2));
        vertex(this.points[3].get(1),this.points[3].get(2));

        endShape(CLOSE);
    }
    translate(dx, dy){
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.translate2D(this.points[i],dx,dy);
        }
    }
    rotation(angle){
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation2D(this.points[i],angle);
        }
    }


}
class Line{
    constructor(x1, y1, x2, y2){
        this.points = [];
        this.points.push(new Vector(2, [x1, y1]));
        this.points.push(new Vector(2, [x2, y2]));

        this.color = '#ffffff';
        this.tr = new Transformations();
    }
    setColor(value){
        this.color = value;
    }
    draw(){
        beginShape();

        strokeWeight(1);
        stroke(this.color);
        fill(this.color);

        vertex(this.points[0].get(1),this.points[0].get(2));
        vertex(this.points[1].get(1),this.points[1].get(2));

        endShape();
    } 
    translate(dx, dy){
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.translate2D(this.points[i],dx,dy);
        }
    }
    rotation(angle){
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation2D(this.points[i],angle);
        }
    }
}
class Triangle{
    constructor(x1,y1,x2,y2,x3,y3){
        this.points = [];
        this.points.push(new Vector(2, [x1, y1]));
        this.points.push(new Vector(2, [x2, y2]));
        this.points.push(new Vector(2, [x3, y3]));

        this.color = '#ffffff';
        this.tr = new Transformations();
    }
    setColor(value){
        this.color = value;
    }
    draw(){
        beginShape();

        strokeWeight(1);
        stroke(this.color);
        fill(this.color);

        vertex(this.points[0].get(1),this.points[0].get(2));
        vertex(this.points[1].get(1),this.points[1].get(2));
        vertex(this.points[2].get(1),this.points[2].get(2));


        endShape(CLOSE);
    } 
    translate(dx, dy){
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.translate2D(this.points[i],dx,dy);
        }
    }
    rotation(angle){
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation2D(this.points[i],angle);
        }
    }

}
class Circle{
 
    constructor(x, y, r ,t){
        if(t < 3)
            throw "A quantidade mínima de triângulos é 3!"
        this.tr = new Transformations();
        var angle = 360/t;
        this.points = [];
        this.points.push(new Vector(2, [0, 0]));
        this.points.push(new Vector(2, [r, 0]));
        for(var i = 2;i < t+2; i++){
            this.points.push(this.tr.rotation2D(this.points[i-1],this.#convertGrauParaRad(angle)));
        }
        this.translate(x,y);

        this.color = '#ffffff';
    }
    setColor(value){
        this.color = value;
    }
    draw(){
        beginShape(TRIANGLES);
                
        strokeWeight(1);
        stroke(this.color);
        fill(this.color);

        for(var i = 0; i < this.points.length; i++){
            if(i < this.points.length-2){
                vertex(this.points[0].get(1),this.points[0].get(2));
                vertex(this.points[i+1].get(1),this.points[i+1].get(2));
                vertex(this.points[i+2].get(1),this.points[i+2].get(2));
            }
        }


        endShape(CLOSE);
    } 
    translate(dx, dy){
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.translate2D(this.points[i],dx,dy);
        }
    }
    rotation(angle){
        for(let i = 0; i < this.points.length; i++){
           this.points[i] = this.tr.rotation2D(this.points[i],angle);
        }
    }
    #convertGrauParaRad(grau){
        return (grau/180)*Math.PI;
    }
}



