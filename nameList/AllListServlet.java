package nameList;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/all-list") // このサーブレットは /all-list でアクセスできる
public class AllListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 各リストを取得
        ArrayList<String> ootachi = ootachiList.getList();
        ArrayList<String> turugi = turugiList.getList();
        ArrayList<String> yari = yariList.getList();
        ArrayList<String> naginata = naginataList.getList();
        // 必要に応じて他のリストも追加

        // すべてのリストを1つにまとめる
        ArrayList<String> all = new ArrayList<>();
        all.addAll(ootachi);   // 大太刀を追加
        all.addAll(turugi);    // 剣を追加
        all.addAll(yari);      // 槍を追加
        all.addAll(naginata);  // 薙刀を追加
        // 他のリストも同様に追加

        // JSON文字列に変換（手動で配列をJSON化）
        String json = "[\"" + String.join("\",\"", all) + "\"]";

        // レスポンスの種類をJSONに設定
        response.setContentType("application/json; charset=UTF-8");
        // クライアントにJSONを返す
        response.getWriter().write(json);
    }
}