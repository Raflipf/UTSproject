package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        // Ambil data dari Intent
        val foodName = intent.getStringExtra("foodName")
        val servings = intent.getStringExtra("servings")
        val orderName = intent.getStringExtra("orderName")
        val notes = intent.getStringExtra("notes")

        // Hubungkan tampilan dengan ID
        val tvFoodName: TextView = findViewById(R.id.tvFoodName)
        val tvServings: TextView = findViewById(R.id.tvServings)
        val tvOrderName: TextView = findViewById(R.id.tvOrderName)
        val tvNotes: TextView = findViewById(R.id.tvNotes)
        val btnBackToMenu: Button = findViewById(R.id.backtoMenu)

        // Set data yang diterima ke TextView
        tvFoodName.text = "Nama Pesanan: $foodName"
        tvServings.text = "Membeli: $servings pcs"
        tvOrderName.text = "Nama Pemesan: $orderName"
        tvNotes.text = "Tambah keterangan: $notes"

        // Tombol "Back to Menu"
        btnBackToMenu.setOnClickListener {
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
            finish() // Tutup ConfirmationActivity setelah kembali ke menu
        }
    }
}
