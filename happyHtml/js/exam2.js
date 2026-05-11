function work(){
    setTimeout(()=>{
    console.log("work start!!");
    const start = Date.now();
    for(let i = 0; i< 1000000; i++){}

    const end = Date.now();
    console.log(end - start + "ms");
    console.log("work end!!")
    }, 0);
}


function work2(callback){
    console.log("work start!!");
    
    setTimeout(()=>{
    console.log("work start!!");
    const start = Date.now();
    for(let i = 0; i< 1000000; i++){}

    const end = Date.now();
    console.log(end - start + "ms");
    console.log("work end!!")

    callback();
    }, 0);
}

work2(()=>{
console.log("work가 끝나면 해야할일");
});


async function process(){
    console.log("안녕!");

    await sleep(3000);
    console.log("반갑습니다.");
}
console.log("process 호출전!");
process();