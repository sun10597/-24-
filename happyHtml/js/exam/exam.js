var name = '나는 전역이다'; // 전역 변수 선언

const obj = {
    name: '객체 내부',
    arrowFunc: () => {
        console.log(this.name); 
    }
};

obj.arrowFunc(); // 출력: '나는 전역이다'e


