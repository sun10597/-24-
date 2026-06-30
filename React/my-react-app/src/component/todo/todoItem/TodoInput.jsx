import { useState } from "react";

function TodoInput({onCreate}){
    const [text, setText] = useState("");

    const handleSubmit = () => {
        if(text.trim() === "") return;

        onCreate(text);
        setText("");
    }

    const handleKeyDown = (e) => {
        if(e.key === 'Enter'){
            handleSubmit();
        }
    }

    return(
        <div>
            <input 
                type="text" 
                value={text} 
                placeholder="할 일을 입력해 주세요" 
                onChange={(e)=>setText(e.target.value)}
                onKeyDown={handleKeyDown}
            ></input>

            <button 
                onClick={handleSubmit} 
                style={{
                    padding: "5px 10px",
                    backgroundColor: "#ff4444",
                    color: "white",
                    border: "none",
                    borderRadius: "4px",}}
            >추가</button>
        </div>
    )
}

export default TodoInput;