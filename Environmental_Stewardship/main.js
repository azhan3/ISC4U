article1 = `
<div class="article-container" id="art">
    <article id="article">
        <h1>The Impact of Technology on Our Environment and Human Health</h1>
        <p>Technology has impacted our environment and human health in both positive and negative ways. On the positive side, technology has allowed us to discover new medical treatments, develop renewable energy sources, and more efficiently manage natural resources. On the other hand, it has contributed to air and water pollution, caused physical and mental health issues, and has been linked to climate change.</p>
        <h2 class="positive">The Positive Impacts of Technology</h2>
        <p>Technology has enabled us to find cures for diseases that once had no known treatments. For example, the polio vaccine was developed using early vaccines. Today, a range of medical advancements have allowed us to treat cancers and other life-threatening illnesses with a much higher success rate.</p>
        <p>Renewable energy sources such as solar, wind, and hydro-power are becoming increasingly viable options thanks to advances in technology. These forms of energy produce little or no emissions, thus reducing our reliance on fossil fuels, which is responsible for a large portion of global warming.</p>
        <p>Technology has also made it easier to manage natural resources. Thanks to advances in data analysis and machine learning, natural resources can be managed more responsibly. For example, more efficient farming practices can help reduce the amount of land being used for mass production, thus minimising deforestation and soil erosion.</p>
        <h2 class="negative">The Negative Impacts of Technology</h2>
        <p>Though technology can be beneficial to our environment and health, it can also have a detrimental impact. Air and water pollution caused by industrial waste and other pollutants have become an increasingly significant problem around the world.</p>
        <p>Technology has been linked to several physical and mental health issues. Prolonged exposure to blue light from screens, radiation from cell phone towers, and lack of physical activity due to too much screen time all can lead to physical ailments such as headaches and eye strain, as well as mental health issues such as depression and anxiety.</p>
        <p>Lastly, technology is one of the major contributors to climate change. The burning of fossil fuels for energy production, transportation, and other uses releases large amounts of carbon dioxide into the atmosphere, which has been linked to increased global temperatures.</p>
        <h2>Conclusion</h2>
        <p>Technology has been both a blessing and a curse to our environment and human health. On the one hand, it has given us cures for deadly diseases, enabled us to generate renewable energy, and allowed us to better manage natural resources. On the other hand, it has led to air and water pollution, physical and mental health issues, and has been linked to climate change.</p>
    </article> <button class="button-6" onclick="return show('Question0','art');">Start Quiz</button> </div>
`

article2 = `
<div class="article-container" id="art">
<article id="article">
    <h1>Ways to Reduce the Negative Impacts of Technology</h1>
    <p>While technology has many positive benefits, it can also have negative impacts on the environment and our health. Here are some ways that we can all help reduce these negative impacts:</p>
    <h2>Reduce Air and Water Pollution</h2>
    <ul>
      <li>Use public transportation, carpool, bike, or walk instead of driving alone in a car.</li>
      <li>Reduce energy use by turning off lights and electronics when not in use.</li>
      <li>Recycle and properly dispose of electronic waste, such as old phones and computers.</li>
      <li>Choose environmentally-friendly products, such as cleaning supplies and personal care products, which are less likely to contain harmful chemicals.</li>
    </ul>
    <h2>Protect Your Health</h2>
    <ul>
      <li>Take frequent breaks from electronic devices to reduce eye strain and headaches.</li>
      <li>Avoid using electronics before bedtime to improve sleep quality.</li>
      <li>Get regular exercise to offset the negative effects of prolonged sitting.</li>
      <li>Limit exposure to electromagnetic radiation by using a headset or speakerphone when making phone calls.</li>
    </ul>

    <h2>Reduce Your Carbon Footprint</h2>
    <ul>
      <li>Switch to energy-efficient light bulbs and appliances to reduce energy consumption.</li>
      <li>Reduce meat consumption, as meat production is a major contributor to greenhouse gas emissions.</li>
      <li>Use renewable energy sources, such as solar or wind power, where possible.</li>
      <li>Offset your carbon footprint by investing in carbon credits or planting trees.</li>
    </ul>

    <p>By following these simple tips, we can all do our part to reduce the negative impacts of technology and create a more sustainable future.</p>
    </article> <button class="button-6" onclick="return show('Question0','art');">Start Quiz</button> </div>
    `
article3 = `
<div class="article-container" id="art">
    <article id="article">
        <h1>Programs and Initiatives for Environmental Stewardship</h1>
        <main>
            <h2>Local Community Programs and Initiatives</h2>
            <p>Many local communities have established programs and initiatives to promote environmental stewardship and reduce the effects of technology. Some examples include:</p>
            <ul>
                <li><strong>Community composting:</strong> Many communities have established composting programs that allow residents to compost their food scraps and yard waste. This reduces the amount of waste that goes to landfills and provides residents with nutrient-rich compost for their gardens.</li>
                <li><strong>Bike-sharing programs:</strong> Bike-sharing programs allow residents to rent bicycles for short trips, reducing the number of cars on the road and promoting active transportation. For example, in cities like Vancouver, you will find many Shaw bike sharing stations scattered around the city</li>
                <li><strong>Green space initiatives:</strong> Many communities are working to create and preserve green spaces such as parks, gardens, and wildlife habitats. These spaces provide important ecosystem services and improve the quality of life for residents.</li>
            </ul>
            <h2>Government Programs and Initiatives</h2>
            <p>Government agencies at the local, national, and international levels have established programs and initiatives to promote environmental stewardship. Some examples include:</p>
            <ul>
                <li><strong>The Clean Air Act:</strong> The Clean Air Act is a federal law that regulates air pollution in the United States. It has been successful in reducing air pollution and improving public health.</li>
                <li><strong>The Paris Agreement:</strong> The Paris Agreement is an international agreement to address climate change. Countries that sign on to the agreement commit to reducing greenhouse gas emissions and working toward a more sustainable future.</li>
                <li><strong>The Endangered Species Act:</strong> The Endangered Species Act is a federal law that protects endangered and threatened species and their habitats. It has been successful in preventing the extinction of many species and promoting biodiversity.</li>
            </ul>
            <h2>Private Organizations</h2>
            <p>Many private organizations have established programs and initiatives to promote environmental stewardship. Some examples include:</p>
            <ul>
                <li><strong>The Nature Conservancy:</strong> The Nature Conservancy is a non-profit organization that works to protect ecologically important lands and waters. They have protected over 119 million acres of land and 5,000 miles of rivers worldwide.</li>
                <li><strong>The Ellen MacArthur Foundation:</strong> The Ellen MacArthur Foundation is a non-profit organization that promotes a circular economy, where waste is eliminated and materials are kept in use for as long as possible. They work with businesses, governments, and other organizations to promote a more sustainable economic model.</li>
                <li><strong>The Rainforest Alliance:</strong> The Rainforest Alliance is a non-profit organization that works to conserve biodiversity and promote sustainable livelihoods in tropical forests. They work with farmers, forest communities, and other stakeholders to promote sustainable land use practices.</li>
            </ul>
    </article> <button class="button-6" onclick="return show('Question0','art');">Start Quiz</button> </div>
`
let sprites = [
    new Sprite(10, 10, "Images/sprite1.png", article1),
    new Sprite(15, 5, "Images/sprite2.png", article2),
    new Sprite(20, 25, "Images/sprite3.png", article3)
];

let quizData = {
    "Images/sprite1.png": {
        question: [
            "Which of the following is a negative impact of technology on human health?", 
            "Which of the following effects on the environment are caused by technologies", 
            "What is a positive impact of technology", 
            "How has technology being used in resource management helped the environment", 
            "What is a negative impact of e-waste on the environment?"],
        answers: [
            ["a) Increased physical activity", "b) Eye strain and headaches", "c) Improved sleep patterns", "d) Increased social interactions"], 
            ["a) Air and water pollution", "b) Global warming", "c) Electronic waste", "d) All of the above"], 
            ["a) Medical advancements", "b) Pollution", "c) Mental health issues", "d) False information"], 
            ["a) It has led to more E-waste being produced", "b) It has developed more efficient farming practices", "c) It has led to more deforestation", "d) Better algorithms for social media"], 
            ["a) It increases biodiversity", "b) It helps reduce greenhouse gas emissions", "c) It can lead to soil and water contamination", "d) It promotes healthy ecosystems"]],
        correctAnswer: [1, 3, 0, 1, 2]
    },
    "Images/sprite2.png": {
        question: [
            "Which of the following is a way to reduce the negative impact of technology on human health?", 
            "What is a way to reduce the negative impact of technology on the environment?", 
            "What is a positive impact of technology on the environment?", 
            "How can we reduce the negative impact of e-waste on the environment?"],
        answers: [
            ["a) Taking breaks from screen time", "b) Using technology in moderation", "c) Both a and b", "d) None of the above"], 
            ["a) Recycling electronic waste", "b) Limiting the use of non-renewable energy sources", "c) Using energy-efficient technology", "d) All of the above"], 
            ["a) More efficient resource management", "b) Increased air and water pollution", "c) Deforestation", "d) None of the above"], 
            ["a) Landfills should be used to dispose of e-waste", "b) E-waste should be exported to other countries for disposal", "c) E-waste should be recycled", "d) All of the above"]],
        correctAnswer: [2, 3, 0, 2]
    },"Images/sprite3.png": {
        question: [
            "Which of the following programs allows residents to compost their food scraps and yard waste?",
            "Which of the following initiatives promotes active transportation?",
            "Which of the following is an international agreement to address climate change?",
            "Which of the following organizations works to protect ecologically important lands and waters?"
        ],
        answers: [
            ["a) Community gardening", "b) Bike-sharing programs", "c) Green space initiatives", "d) None of the above"],
            ["a) Clean Air Act", "b) Paris Agreement", "c) Endangered Species Act", "d) Bike-sharing programs"],
            ["a) The Clean Air Act", "b) The Paris Agreement", "c) The Endangered Species Act", "d) None of the above"],
            ["a) The Nature Conservancy", "b) The Ellen MacArthur Foundation", "c) The Rainforest Alliance", "d) None of the above"]
        ],
        correctAnswer: [0, 1, 1, 0]
        }
    }


let spritesContainer = document.getElementById('sprites');
for (let i = 0; i < sprites.length; i++) {
    let sprite = sprites[i];
    let element = sprite.createElement();
    element.addEventListener('click', () => {
        const quiz = new Quiz(quizData, sprite.src);
        quiz.Initialize();
        quiz.writeArticle(sprite.article);
        quiz.showQuiz();
    });
    spritesContainer.appendChild(element);
}