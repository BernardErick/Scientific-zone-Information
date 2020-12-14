class Parallelogram{
    constructor(x, y, z, w, h, l){
        this.points = [];
        this.points.push(new Vector(3,[x ,y ,z]));
        this.points.push(new Vector(3,[x +w , y ,z]));
        this.points.push(new Vector(3,[x + w ,y + h ,z]));
        this.points.push(new Vector(3,[x ,y + h ,z]));

        this.points.push(new Vector(3,[x ,y ,z -l]));
        this.points.push(new Vector(3,[x +w , y ,z -l]));
        this.points.push(new Vector(3,[x + w ,y + h ,z -l]));
        this.points.push(new Vector(3,[x ,y + h ,z - l]));

        
        this.color = '#ffffff';
        this.tr = new Transformations();

    }

    draw(){
        beginShape(TRIANGLES);
                
        strokeWeight(1);
        stroke(this.color);
        fill(this.color);

        //Face frontal
        vertex(this.points[0].get(1),this.points[0].get(2),this.points[0].get(3));
        vertex(this.points[1].get(1),this.points[1].get(2),this.points[1].get(3));
        vertex(this.points[3].get(1),this.points[3].get(2),this.points[3].get(3));

        vertex(this.points[1].get(1),this.points[1].get(2),this.points[1].get(3));
        vertex(this.points[2].get(1),this.points[2].get(2),this.points[2].get(3));
        vertex(this.points[3].get(1),this.points[3].get(2),this.points[3].get(3));

        //Face traseira
        vertex(this.points[4].get(1),this.points[4].get(2),this.points[4].get(3));
        vertex(this.points[5].get(1),this.points[5].get(2),this.points[5].get(3));
        vertex(this.points[7].get(1),this.points[7].get(2),this.points[7].get(3));

        vertex(this.points[5].get(1),this.points[5].get(2),this.points[5].get(3));
        vertex(this.points[6].get(1),this.points[6].get(2),this.points[6].get(3));
        vertex(this.points[7].get(1),this.points[7].get(2),this.points[7].get(3));

        //Face esquerda
        vertex(this.points[0].get(1),this.points[0].get(2),this.points[0].get(3));
        vertex(this.points[3].get(1),this.points[3].get(2),this.points[3].get(3));
        vertex(this.points[7].get(1),this.points[7].get(2),this.points[7].get(3));

        vertex(this.points[0].get(1),this.points[0].get(2),this.points[0].get(3));
        vertex(this.points[4].get(1),this.points[4].get(2),this.points[4].get(3));
        vertex(this.points[7].get(1),this.points[7].get(2),this.points[7].get(3));

        //Face direita
        vertex(this.points[1].get(1),this.points[1].get(2),this.points[1].get(3));
        vertex(this.points[2].get(1),this.points[2].get(2),this.points[2].get(3));
        vertex(this.points[6].get(1),this.points[6].get(2),this.points[6].get(3));

        vertex(this.points[1].get(1),this.points[1].get(2),this.points[1].get(3));
        vertex(this.points[5].get(1),this.points[5].get(2),this.points[5].get(3));
        vertex(this.points[6].get(1),this.points[6].get(2),this.points[6].get(3));

        //Face superior
        vertex(this.points[0].get(1),this.points[0].get(2),this.points[0].get(3));
        vertex(this.points[1].get(1),this.points[1].get(2),this.points[1].get(3));
        vertex(this.points[4].get(1),this.points[4].get(2),this.points[4].get(3));
        
        vertex(this.points[1].get(1),this.points[1].get(2),this.points[1].get(3));
        vertex(this.points[4].get(1),this.points[4].get(2),this.points[4].get(3));
        vertex(this.points[5].get(1),this.points[5].get(2),this.points[5].get(3));

        //Face inferior
        vertex(this.points[3].get(1),this.points[3].get(2),this.points[3].get(3));
        vertex(this.points[2].get(1),this.points[2].get(2),this.points[2].get(3));
        vertex(this.points[7].get(1),this.points[7].get(2),this.points[7].get(3));
        
        vertex(this.points[2].get(1),this.points[2].get(2),this.points[2].get(3));
        vertex(this.points[7].get(1),this.points[7].get(2),this.points[7].get(3));
        vertex(this.points[6].get(1),this.points[6].get(2),this.points[6].get(3));

        endShape(CLOSE);

    }
    setColor(value){
        this.color = value;
    }
    translate(dx, dy,dz){
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.translate3D(this.points[i],dx,dy,dz);
        }
    }
    rotation(x,y,z){
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation3Dx(this.points[i],x);
        }
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation3Dy(this.points[i],y);
        }
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation3Dz(this.points[i],z);
        }
    }
}
class Plane{
    constructor(x , y , z , w, h ,l){
        this.points = [];
        this.points.push(new Vector(3,[x ,y ,z]));
        this.points.push(new Vector(3,[x + w , y , z]));
        this.points.push(new Vector(3,[x + w , y + h,z + l]));
        this.points.push(new Vector(3,[x , y + h,z + l]));

        this.color = '#ffffff';
        this.tr = new Transformations();
    }
    draw(){
        beginShape(TRIANGLES);
            
        strokeWeight(1);
        stroke(this.color);
        fill(this.color);

        vertex(this.points[0].get(1),this.points[0].get(2),this.points[0].get(3));
        vertex(this.points[1].get(1),this.points[1].get(2),this.points[1].get(3));
        vertex(this.points[2].get(1),this.points[2].get(2),this.points[2].get(3));

        vertex(this.points[0].get(1),this.points[0].get(2),this.points[0].get(3));
        vertex(this.points[2].get(1),this.points[2].get(2),this.points[2].get(3));
        vertex(this.points[3].get(1),this.points[3].get(2),this.points[3].get(3));

        endShape(CLOSE)
    }
    setColor(value){
        this.color = value;
    }
    translate(dx, dy,dz){
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.translate3D(this.points[i],dx,dy,dz);
        }
    }
    rotation(x,y,z){
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation3Dx(this.points[i],x);
        }
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation3Dy(this.points[i],y);
        }
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation3Dz(this.points[i],z);
        }
    }
}
class Pyramid{
   constructor(x, y, z, w, h, l, hp){
    this.points = [];
    this.points.push(new Vector(3,[x ,y ,z]));
    this.points.push(new Vector(3,[x + w , y , z]));
    this.points.push(new Vector(3,[x + w, y , z + l]));
    this.points.push(new Vector(3,[x , y ,z + l]));
    this.points.push(new Vector(3,[ this.points[2].get(1)/2, h + hp, this.points[2].get(3)/2]));

    this.color = '#ffffff';
    this.tr = new Transformations();
   }
   draw(){
    beginShape(TRIANGLES);
        
    strokeWeight(1);
    stroke(this.color);
    fill(this.color);

    vertex(this.points[0].get(1),this.points[0].get(2),this.points[0].get(3));
    vertex(this.points[1].get(1),this.points[1].get(2),this.points[1].get(3));
    vertex(this.points[2].get(1),this.points[2].get(2),this.points[2].get(3));

    vertex(this.points[0].get(1),this.points[0].get(2),this.points[0].get(3));
    vertex(this.points[2].get(1),this.points[2].get(2),this.points[2].get(3));
    vertex(this.points[3].get(1),this.points[3].get(2),this.points[3].get(3));

    vertex(this.points[4].get(1),this.points[4].get(2),this.points[4].get(3));
    vertex(this.points[1].get(1),this.points[1].get(2),this.points[1].get(3));
    vertex(this.points[2].get(1),this.points[2].get(2),this.points[2].get(3));

    vertex(this.points[4].get(1),this.points[4].get(2),this.points[4].get(3));
    vertex(this.points[2].get(1),this.points[2].get(2),this.points[2].get(3));
    vertex(this.points[3].get(1),this.points[3].get(2),this.points[3].get(3));

    vertex(this.points[4].get(1),this.points[4].get(2),this.points[4].get(3));
    vertex(this.points[3].get(1),this.points[3].get(2),this.points[3].get(3));
    vertex(this.points[0].get(1),this.points[0].get(2),this.points[0].get(3));
    
    vertex(this.points[4].get(1),this.points[4].get(2),this.points[4].get(3));
    vertex(this.points[0].get(1),this.points[0].get(2),this.points[0].get(3));
    vertex(this.points[1].get(1),this.points[1].get(2),this.points[1].get(3));

    endShape(CLOSE)
    }
    setColor(value){
        this.color = value;
    }
    translate(dx, dy, dz){
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.translate3D(this.points[i],dx,dy,dz);
        }
    }
    rotation(x,y,z){
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation3Dx(this.points[i],x);
        }
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation3Dy(this.points[i],y);
        }
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation3Dz(this.points[i],z);
        }
    }
}
class Sphere{
    constructor(x , y , z , r , st , se){
        this.tr = new Transformations();
        this.color = '#ffffff';
        this.st = st;
        this.se = se;
        this.points = [];
        this.points.push(new Vector(3,[0,0,0]));
        this.x = x;
        this.y = y;
        this.z = z;
        
        for(var i = 0; i <= st ;i++){
            var angleSt = Math.PI * (i/st);
            for(var j = 0;j <= se;j++){
                var angleSe = (Math.PI*2) * (j/se);
                this.points.push(this.tr.rotation3Dx(this.tr.rotation3D(new Vector(3,[r,0,0]),angleSt),angleSe));
            }
        } 
    
        this.translate(x,y,z);
    }

    draw(){
        beginShape(TRIANGLES);
                
        strokeWeight(1);
        stroke(this.color);
        fill(this.color);

        var k1, k2;
        for(var i = 0; i < this.st; i++)
        {
            k1 = i * (this.se + 1);     
            k2 = k1 + this.se + 1;      
        
            for(var j = 0; j < this.se; j++)
            {
                k1++;
                k2++;
                if(i != 0)
                {
                    vertex(this.points[k1].get(1),this.points[k1].get(2),this.points[k1].get(3));
                    vertex(this.points[k2].get(1),this.points[k2].get(2),this.points[k2].get(3));
                    vertex(this.points[k1+1].get(1),this.points[k1+1].get(2),this.points[k1+1].get(3));
                }
        
                if(i != (this.st-1))
                {
                    vertex(this.points[k1+1].get(1),this.points[k1+1].get(2),this.points[k1+1].get(3));
                    vertex(this.points[k2].get(1),this.points[k2].get(2),this.points[k2].get(3));
                    vertex(this.points[k2+1].get(1),this.points[k2+1].get(2),this.points[k2+1].get(3));
                }

            }
        }

        endShape(CLOSE);
    }
    setColor(value){
        this.color = value;
    }
    translate(dx, dy, dz){
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.translate3D(this.points[i],dx,dy,dz);
        }
    }

    rotation(x,y,z){
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation3Dx(this.points[i],x);
        }
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation3Dy(this.points[i],y);
        }
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation3Dz(this.points[i],z);
        }
    }

}
/*
class Line3D{
    constructor(x1, y1, z1, x2, y2, z2){
        this.points = [];
        this.points.push(new Vector(3, [x1, y1, z1]));
        this.points.push(new Vector(3, [x2, y2, z2]));
        this.color = '#000000';
        this.tr = new Transformations();
    }
    setColor(value){
        this.color = value;
    }
    draw(){
        beginShape();

        strokeWeight(5);
        stroke(this.color);
        fill(this.color);

        vertex(this.points[0].get(1),this.points[0].get(2),this.points[0].get(3));
        vertex(this.points[1].get(1),this.points[1].get(2),this.points[1].get(3));

        endShape();
    } 
    translate(dx, dy, dz){
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.translate3D(this.points[i],dx,dy,dz);
        }
    }
    rotation(x,y,z){
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation3Dx(this.points[i],x);
        }
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation3Dy(this.points[i],y);
        }
        for(let i = 0; i < this.points.length; i++){
            this.points[i] = this.tr.rotation3Dz(this.points[i],z);
        }
    }
}
*/