import { useState } from "react";

const UseStateExam01 = () =>{
    const [count, setCount] = useState(0);
    
    const upClick = () =>{
        setCount(count + 1);
        console.log(count + 1);
    }
    const downClick = () =>{
        setCount(count - 1);
        onsole.log(count + -1);

    }
    
    return (
        <div>
            <p>카운트 : {count}</p>
            <button onClick={upClick}>up</button>
            <button onClick={downClick}>down</button>
        </div>
    )
}

export default UseStateExam01;