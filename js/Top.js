// サーブレットから全リストを取得する関数
async function fetchAllList() {
  const res = await fetch('/git-2136/all-list'); // プロジェクト名に合わせて修正
  const list = await res.json();
  return list;
}

function getRandomMembers(list, num) {
  const copy = [...list];
  const result = [];
  for (let i = 0; i < num && copy.length > 0; i++) {
    const idx = Math.floor(Math.random() * copy.length);
    result.push(copy.splice(idx, 1)[0]);
  }
  return result;
}

document.getElementById("randomBtn").addEventListener("click", async function() {
  console.log("ボタンが押されました");
  const allList = await fetchAllList();
  console.log(allList);
  const members = getRandomMembers(allList, 6);
  const ul = document.getElementById("result");
  ul.innerHTML = "";
  members.forEach(name => {
    const li = document.createElement("li");
    li.textContent = name;
    ul.appendChild(li);
  });
});