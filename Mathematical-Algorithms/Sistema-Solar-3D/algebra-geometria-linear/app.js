let tamSol = 150;

let tamTerra = tamSol * (1/109);
//distancia da terra
let distTerra = 250
let sol
let terra
let lua;
let mercurio
let venus
let marte
let jupiter
let saturno
let urano
let netuno
let plutao;
let mt1;
let mt2;
let jl1;
let jl2;
let jl3;
let st1;
let st2;
let st3;
let ul1
let ul2
let ul3
let nl1
let nl2
let nl3;
let pl1;
let pl2;
let pl3;

function setup(){
    frameRate(60);
    createCanvas(1200,700,WEBGL);

    createEasyCam();

    sol = new Sphere(0,0,0,tamSol,20,20);
    sol.setColor('#ffff00');
    terra = new Sphere(distTerra,0,0,tamTerra,10,10);
    lua = new Sphere(distTerra,0,30,tamTerra*0.2724,10,10);
    mercurio = new Sphere(distTerra - distTerra * 0.387,0,0,tamTerra*0.383,10,10);
    venus = new Sphere(distTerra  * 0.723,0,0,tamTerra*0.949,10,10);
    marte = new Sphere(distTerra  * 1.52,0,0,tamTerra*0.532,10,10);
    jupiter = new Sphere(distTerra  * 5.20,0,0,tamTerra*11.21,10,10);
    saturno = new Sphere(distTerra  * 9.58,0,0,tamTerra*9.45,10,10);
    urano = new Sphere(distTerra  * 19.20,0,0,tamTerra*4.01,10,10);
    netuno = new Sphere(distTerra  * 30.05,0,0,tamTerra*3.88,10,10);
    plutao = new Sphere(distTerra  * 39.48,0,0,tamTerra*0.186,10,10);

    mt1 = new Sphere(distTerra  * 1.52 + 30,0,0,tamTerra*0.2724,10,10);
    mt2 = new Sphere(distTerra  * 1.52,30,0,tamTerra*0.2724,10,10);

    jl1 = new Sphere(distTerra  * 5.20 + 30,0,0,tamTerra*0.2724,10,10);
    jl2 = new Sphere(distTerra  * 5.20 ,30,0,tamTerra*0.2724,10,10);
    jl3 = new Sphere(distTerra  * 5.20 ,0,30,tamTerra*0.2724,10,10);

    sl1 = new Sphere(distTerra  * 9.58 +30,0,0,tamTerra*0.2724,10,10);
    sl2 = new Sphere(distTerra  * 9.58 ,30,0,tamTerra*0.2724,10,10);
    sl3 = new Sphere(distTerra  * 9.58 +30,0,30,tamTerra*0.2724,10,10);

    ul1 = new Sphere(distTerra  * 19.20 + 30,0,0,tamTerra*0.2724,10,10);
    ul2 = new Sphere(distTerra  * 19.20 , 30,0,tamTerra*0.2724,10,10);
    ul3 = new Sphere(distTerra  * 19.20 ,0,30,tamTerra*0.2724,10,10);

    nl1 = new Sphere(distTerra  * 30.05 + 30,0,0,tamTerra*0.2724,10,10);
    nl2 = new Sphere(distTerra  * 30.05 ,30,0,tamTerra*0.2724,10,10);
    nl3 = new Sphere(distTerra  * 30.05 ,0,30,tamTerra*0.2724,10,10);

    pl1 = new Sphere(distTerra  * 39.48 + 30,0,0,tamTerra*0.2724,10,10);
    pl2 = new Sphere(distTerra  * 39.48 ,30,0,tamTerra*0.2724,10,10);
    pl3 = new Sphere(distTerra  * 39.48 ,0,30,tamTerra*0.2724,10,10);

}
function draw(){
    background('#556B2F');

    //figuras
    sol.draw();
    sol.rotation(0,1,0)
    terra.draw();
    terra.rotation(0,tamTerra,0)
    lua.draw();
    lua.rotation(0,tamTerra,0);
    mercurio.draw();
    mercurio.rotation(0,tamTerra*1.59,0)
    venus.draw();
    venus.rotation(0,tamTerra*1.18,0);
    marte.draw();
    mt1.draw();
    mt2.draw();
    marte.rotation(0,tamTerra*0.808,0);
    mt1.rotation(0,tamTerra*0.808,0);
    mt2.rotation(0,tamTerra*0.808,0);
    jupiter.draw();
    jl1.draw();
    jl2.draw();
    jl3.draw();
    jupiter.rotation(0,tamTerra*0.439,0);
    jl1.rotation(0,tamTerra*0.439,0);
    jl2.rotation(0,tamTerra*0.439,0);
    jl3.rotation(0,tamTerra*0.439,0);
    saturno.draw();
    sl1.draw();
    sl2.draw();
    sl3.draw();
    saturno.rotation(0,tamTerra*0.325,0);
    sl1.rotation(0,tamTerra*0.325,0);
    sl2.rotation(0,tamTerra*0.325,0);
    sl3.rotation(0,tamTerra*0.325,0);
    urano.draw();
    ul1.draw();
    ul2.draw();
    ul3.draw();
    urano.rotation(0,tamTerra*0.228,0)
    ul1.rotation(0,tamTerra*0.228,0)
    ul2.rotation(0,tamTerra*0.228,0)
    ul3.rotation(0,tamTerra*0.228,0)
    netuno.draw();
    nl1.draw();
    nl2.draw();
    nl3.draw();
    netuno.rotation(0,tamTerra*0.182,0);
    nl1.rotation(0,tamTerra*0.182,0);
    nl2.rotation(0,tamTerra*0.182,0);
    nl3.rotation(0,tamTerra*0.182,0);
    plutao.draw();
    plutao.rotation(0,tamTerra*0.157,0);
    pl1.rotation(0,tamTerra*0.157,0);
    pl2.rotation(0,tamTerra*0.157,0);
    pl3.rotation(0,tamTerra*0.157,0);

}
