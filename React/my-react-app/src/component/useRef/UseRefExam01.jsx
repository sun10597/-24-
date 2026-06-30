import { useRef, useState } from "react";

const UseRefExam01=()=>{
    let countLet = 0;
    const [countState, setCountState] = useState(0);
    const countRef = useRef(0);

    const increaseState = () =>{
        setCountState(countState + 1);
    }

    const increaseLet = () => {
        countLet++;
    }

    const increaseRef = () => {
        countRef.current++;
    }

    return(
        <div>
            <p>sueState:: {countState}</p>
            <p>Let:: {countLet}</p>
            <p>useRef:: {countRef.current}</p>

            <button onClick={increaseState}>useState UP</button>
            <button onClick={increaseLet}>let UP</button>
            <button onClick={increaseRef}>useRef UP</button>
        </div>
    )
}

export default UseRefExam01;