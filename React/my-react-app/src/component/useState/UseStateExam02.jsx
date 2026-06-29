import { useState } from "react";

const UseStateExam02 = () => {
    const [inputName, setInputName] = useState("");
    const [names, setNames] = useState(["kim", "lee", "kang"]);

    const inputChangeHamdler = (e) => {
        setInputName(e.target.value);
    };

    const addHandler = () => {
        setNames((prevState) => {
            return [inputName, ...prevState];
        });
        setInputName("");
    };

    const keyDownhandler = (e) => {
        if(e.key === 'Enter'){
            addHandler("");
        }
    };

    return(
        <div>
            <input type="text" value={inputName} onChange={inputChangeHamdler} onKeyDown={keyDownhandler}></input>
            <button onClick={addHandler}>추가</button>
            {names.map((name, index) => (
                <p key={index}>{name}</p>
            ))}
        </div>
    )
}

export default UseStateExam02;