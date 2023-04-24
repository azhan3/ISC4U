class Quiz {
    constructor(quizData, spriteSrc) {
        this.data = quizData[spriteSrc];
        this.questions = this.data.question;
        this.answers = this.data.answers;
        this.correctAnswer = this.data.correctAnswer;
        this.popup = window.open('', '_blank', 'width=650,height=650');

    }
    writeArticle(article) {
        this.popup.document.write(article);

        this.popup.document.write(`<style>
		h1 {
			text-align: center;
			margin-top: 50px;
			margin-bottom: 30px;
		}
        h2 {
            text-align: center;
        }
		p {
			font-size: 18px;
			line-height: 1.5;
			margin-bottom: 20px;
			text-align: justify;
			padding: 0 50px;
		}

		.positive {
			color: green;
			font-weight: bold;
		}

		.negative {
			color: red;
			font-weight: bold;
		}

		.section-title {
			font-size: 24px;
			font-weight: bold;
			margin-bottom: 20px;
		}

		ul {
			margin-left: 40px;
			margin-bottom: 20px;
		}

		li {
			margin-bottom: 10px;
		}
	</style>`);
    }
    Initialize() {
        this.popup.document.write(`
        <head>
            <style>
            .radiogroup {
                padding: 48px 64px;
                border-radius: 16px;
                background: #ecf0f3;
                box-shadow:
                  4px 4px 4px 0px #d1d9e6 inset,
                  -4px -4px 4px 0px #ffffff inset;
              }
              
              
              .wrapper {
                margin: 8px 0;
              }
              
              .state {
                position: absolute;
                top: 0;
                right: 0;
                opacity: 1e-5;
                pointer-events: none;
              }
              
              .label {
                display: inline-flex;
                align-items: center;
                cursor: pointer;
                color: #394a56;
              }
              
              .text {
                margin-left: 16px;
                opacity: .6;
                transition: opacity .2s linear, transform .2s ease-out;
              }
              
              .indicator {
                position: relative;
                border-radius: 50%;
                height: 30px;
                width: 30px;
                box-shadow:
                  -8px -4px 8px 0px #ffffff,
                  8px 4px 12px 0px #d1d9e6;
                overflow: hidden;
              }
              
              .indicator::before,
              .indicator::after {
                content: '';
                position: absolute;
                top: 10%;
                left: 10%;
                height: 80%;
                width: 80%;
                border-radius: 50%;
              }
              
              .indicator::before {
                box-shadow:
                  -4px -2px 4px 0px #d1d9e6,
                  4px 2px 8px 0px #fff;
              }
              
              .indicator::after {
                background-color: #ecf0f3;
                box-shadow:
                  -4px -2px 4px 0px #fff,
                  4px 2px 8px 0px #d1d9e6;
                transform: scale3d(1, 1, 1);
                transition: opacity .25s ease-in-out, transform .25s ease-in-out;
              }
              
              .state:checked ~ .label .indicator::after {
                transform: scale3d(.975, .975, 1) translate3d(0, 10%, 0);
                opacity: 0;
              }
              
              .state:focus ~ .label .text {
                transform: translate3d(8px, 0, 0);
                opacity: 1;
              }
              
              .label:hover .text {
                opacity: 1;
              }
            .button-6 {
                align-items: center;
                background-color: #FFFFFF;
                border: 1px solid rgba(0, 0, 0, 0.1);
                border-radius: .25rem;
                box-shadow: rgba(0, 0, 0, 0.02) 0 1px 3px 0;
                box-sizing: border-box;
                color: rgba(0, 0, 0, 0.85);
                cursor: pointer;
                display: inline-flex;
                font-family: system-ui,-apple-system,system-ui,"Helvetica Neue",Helvetica,Arial,sans-serif;
                font-size: 16px;
                font-weight: 600;
                justify-content: center;
                line-height: 1.25;
                margin: 0;
                min-height: 3rem;
                padding: calc(.875rem - 1px) calc(1.5rem - 1px);
                position: relative;
                text-decoration: none;
                transition: all 250ms;
                user-select: none;
                -webkit-user-select: none;
                touch-action: manipulation;
                vertical-align: baseline;
                width: auto;
              }
              
              .button-6:hover,
              .button-6:focus {
                border-color: rgba(0, 0, 0, 0.15);
                box-shadow: rgba(0, 0, 0, 0.1) 0 4px 12px;
                color: rgba(0, 0, 0, 0.65);
              }
              
              .button-6:hover {
                transform: translateY(-1px);
              }
              
              .button-6:active {
                background-color: #F0F0F1;
                border-color: rgba(0, 0, 0, 0.15);
                box-shadow: rgba(0, 0, 0, 0.06) 0 2px 4px;
                color: rgba(0, 0, 0, 0.65);
                transform: translateY(0);
              }
            </style>
            <script>
            function show(shown, hidden) { 
                document.getElementById(shown).style.display='block'; 
                document.getElementById(hidden).style.display='none'; 
                return false; 
            } 
            function checkAnswer(correctAnswer) { 
                let answer = -1; 
                let total = correctAnswer.length; 
                let correct = 0; 
                for (let i = 0 ; i < correctAnswer.length ; ++i) { 
                    let radios = document.getElementsByName(\`answer\${i}\`); 
                    console.log(radios); 
                    for (let x = 0; x < radios.length; x++) { 
                        if (radios[x].checked) { 
                            answer = radios[x].value; 
                        } 
                    } 
                    if (answer == correctAnswer[i]) { 
                        correct++; 
                    } 
                } 
                console.log(\`\${correct}/\${total}\`); 
                document.getElementById('Question${this.questions.length}').innerHTML = \` 
                    <h1>You Got \${correct}/\${total} Correct</h1> 
                    <button class="button-6" role="button" onclick="window.close()">Exit</button> 
                \`; 
                show('Question${this.questions.length}','Question${this.questions.length - 1}'); 
            } 
            </script> 
    
        </head>
        <body>
        `);
    }
    showQuiz() {
        // Show quiz in this.popup
        for (let i = 0; i < this.questions.length; ++i) {
            let QandA = ``;
            for (let j = 0; j < this.answers[i].length; j++) {
                QandA += `
                <div class="wrapper">
                    <input class="state" type="radio" name="answer${i}" id="${i}${j}" value="${j}">
                    <label class="label" for="${i}${j}">
                    <div class="indicator"></div>
                    <span class="text">${this.answers[i][j]}</span>
                    </label>
                </div>
                `            }
            this.popup.document.write(` 
            <div id="Question${i}" style="display:none" class="radiogroup"> 
                <h1>${this.questions[i]}</h1> 
                ${QandA} 
                <button class="button-6" role="button" onclick="return show('${i > 0 ? `Question${i - 1}` : "art"}','Question${i}');">Back</button>
                
                <button class="button-6" role="button" onclick="${i == this.questions.length - 1 ? `checkAnswer([${this.correctAnswer}])` : `return show('Question${i + 1}','Question${i}');`}">${i == this.questions.length - 1 ? "Submit" : "Next"}</button> 
            </div> 
            `);
        }
        this.popup.document.write(` 
            <div id="Question${this.questions.length}" style="display:none"> 
            </div> 
        `);
    }
}