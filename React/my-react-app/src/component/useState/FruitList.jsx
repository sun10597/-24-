function FruitList(){
    const fruits = ["사과", "오렌지", "바나나", "복숭아", "포도", "딸기"];
    return (
        <div>
            <ul>
                {fruits.map((fruit, index) => (
                    <li key={index}>{fruit}</li>
                ))}
            </ul>
        </div>
    )
}

export default FruitList;