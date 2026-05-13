let strValue = "a+b="+add(1,3);

let str = `a+b=${add(1,3)}`;

const person = {
    name : "kang",
    age : 11,
    address : "서울시"
};

let personName = person.name;

let {address,name,age} = person;

function print({name, age}){
    console.log(name);
    console.log(age);
}