import { useState } from "react";

const TextExam = () => {
    const [text, setText] = useState("");

    const textHandler = (e) =>{
        setText(e.target.value);
    };
    return(
        <div>
            <input type="text" value={text} onChange={textHandler} placeholder="텍스트를 입력하세요."/>
            <p>{text}</p>
        </div>
    )
}

export default TextExam;