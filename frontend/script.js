const API_BASE = (window.location.hostname.includes('vercel') || window.location.hostname.includes('localhost')) 
  ? 'https://your-backend-name.onrender.com/api' 
  : 'https://your-backend-name.onrender.com/api';

function updateSubjects() {
  const level = document.getElementById("level").value;
  const subjectsDiv = document.getElementById("subjects");
  subjectsDiv.innerHTML = "";

  let subjects = [];
  if (level === "10th")
    subjects = ["Tamil", "English", "Maths", "Science", "Social Science"];
  else if (level === "12th")
    subjects = ["Tamil", "English", "Physics", "Chemistry", "Maths", "Biology"];
  else if (level === "Engineering")
    subjects = Array.from({ length: 8 }, (_, i) => `Semester ${i + 1}`);
  else if (level === "Arts")
    subjects = Array.from({ length: 6 }, (_, i) => `Semester ${i + 1}`);

  subjects.forEach(sub => {
    const label = document.createElement("label");
    label.textContent = sub;
    const input = document.createElement("input");
    input.type = "number";
    input.placeholder = `Enter marks for ${sub}`;
    input.classList.add("mark");
    subjectsDiv.appendChild(label);
    subjectsDiv.appendChild(input);
  });
}

async function generatePercentage() {
  const username = document.getElementById("username").value.trim();
  const level = document.getElementById("level").value;
  const marks = Array.from(document.querySelectorAll(".mark")).map(i => parseFloat(i.value) || 0);
  const resultBox = document.getElementById("resultBox");

  if (!username || !level || marks.some(m => m <= 0)) {
    alert("⚠️ Please fill all fields correctly!");
    return;
  }

  try {
    const response = await fetch(`${API_BASE}/calculate`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ username, level, marks }),
    });

    if (!response.ok) throw new Error('Network response was not ok');
    const data = await response.json();
    resultBox.style.display = "block";
    resultBox.textContent = `🎉 Hi ${data.student.username || username}! Your ${level} Percentage is: ${data.percentage.toFixed(2)}%`;
  } catch (err) {
    alert("Backend not reachable. Check backend URL and CORS. " + err.message);
  }
}
