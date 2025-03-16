
//timer code start

var timerInterval;

        function startTimer() {
            var startButton = document.getElementById('myButton');

 var operator = document.getElementById("operator");
    operator.style.display = "inline";
            startButton.disabled = true;

  
            var seconds = 15; // Set the timer duration in seconds
            timerInterval = setInterval(function() {
                seconds--;
                if (seconds <= 0) {
                    clearInterval(timerInterval);
                    document.getElementById('timerForm').submit();
                }
            }, 1000);
            
             let totalSeconds = 15;
  updateTimerDisplay(totalSeconds);
  timerInterval = setInterval(() => {
    totalSeconds--;
    updateTimerDisplay(totalSeconds);
    
    if (totalSeconds <= 0) {
      clearInterval(timerInterval);
      document.getElementById('timerDisplay').textContent = 'Timer Expired';
    }
  }, 1000);
  
        }

        document.getElementById('submitButton').addEventListener('click', function() {
            clearInterval(timerInterval);
            document.getElementById('timerForm').submit();
        });
        
  function updateTimerDisplay(totalSeconds) {
  const minutes = Math.floor(totalSeconds / 60);
  let seconds = totalSeconds % 60;
  
  seconds = seconds < 10 ? '0' + seconds : seconds; // Add leading zero if seconds < 10
  
  document.getElementById('timerDisplay').textContent = `${minutes}:${seconds}`;
}


//timer code end


/*let timerInterval;

function setTimer() {
  clearInterval(timerInterval); // Clear any existing timer
  
  const levelSelect = document.getElementById('');
  const selectedValue = parseInt(levelSelect.value);
  
  let totalSeconds = selectedValue;
  updateTimerDisplay(totalSeconds);
  
  timerInterval = setInterval(() => {
    totalSeconds--;
    updateTimerDisplay(totalSeconds);
    
    if (totalSeconds <= 0) {
      clearInterval(timerInterval);
      document.getElementById('timerDisplay').textContent = 'Timer Expired';
    }
  }, 1000);
}

function updateTimerDisplay(totalSeconds) {
  const minutes = Math.floor(totalSeconds / 60);
  let seconds = totalSeconds % 60;
  
  seconds = seconds < 10 ? '0' + seconds : seconds; // Add leading zero if seconds < 10
  
  document.getElementById('timerDisplay').textContent = `${minutes}:${seconds}`;
}//timer code end



//generate operator
/*function disableButton() {
    var button = document.getElementById("myButton");
    button.style.disabled = "none";
    var operator = document.getElementById("operator");
    operator.style.display = "inline";
}*/



/*function verifyInput() {
    var input = document.getElementById("input").value;
    
    // Perform input verification logic here
    if (input === "") {
        document.getElementById("result").textContent = "Please enter a value.";
    } else if (input.length < 5) {
        document.getElementById("result").textContent = "Input must be at least 5 characters long.";
    } else {
        document.getElementById("result").textContent = "Input is valid. Submitting form...";
        document.querySelector("form").submit();
    }
}

//evaluate anwer

const form = document.getElementById('eveAns');
const answerInput = document.getElementById('answer');
const resultSpan = document.getElementById('result');

form.addEventListener('submit', (e) => {
    e.preventDefault(); // Prevent form submission

    const userAnswer = answerInput.value.trim();
    const correctAnswer = 'correct answer'; // Replace with the correct answer

    if (userAnswer === correctAnswer) {
        resultSpan.textContent = 'Correct!';
        resultSpan.style.color = 'green';
    } else {
        resultSpan.textContent = 'Incorrect. Try again!';
        resultSpan.style.color = 'red';
    }
});




const minutesDisplay = document.getElementById('minutes');
const secondsDisplay = document.getElementById('seconds');
const startBtn = document.getElementById('startBtn');
const stopBtn = document.getElementById('stopBtn');
const resetBtn = document.getElementById('resetBtn');

let intervalId;
let timeLeft = 0;
let isRunning = false;

function startTimer() {
  isRunning = true;
  intervalId = setInterval(() => {
    timeLeft--;
    updateTimerDisplay();
    if (timeLeft === 0) {
      stopTimer();
      alert('time up');
    }
  }, 1000);
} 

function stopTimer() {
  isRunning = false;
  clearInterval(intervalId);
}



function updateTimerDisplay() {
  const seconds = timeLeft % 10;
  secondsDisplay.textContent = String(seconds).padStart(2, '0');
}

startBtn.addEventListener('click', () => {
  if (!isRunning) {
    const seconds = 10;
  
    timeLeft = seconds;
    startTimer();
   
  }
});*/



