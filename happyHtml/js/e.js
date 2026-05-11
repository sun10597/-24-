const person = [
    { name: '김철수', age: 25 }, 
    {name:'김철수', age:20}
];

for (let key of person) {
    console.log(key.name, key.age);
}


const people = {
    person1: { name: '김철수', age: 25 },
    person2: { name: '이영희', age: 20 }
};

for (let key in people) {
    // console.log(`${key}의 이름: ${people[key].name}`);
    console.log(`${people[key].name} ${people[key].age}`);

}