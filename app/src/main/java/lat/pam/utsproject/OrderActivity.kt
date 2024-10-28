package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        val foodName = intent.getStringExtra("foodName")

        val etFoodName: TextView = findViewById(R.id.etFoodName)
        val etServings: EditText = findViewById(R.id.etServings)
        val etName: EditText = findViewById(R.id.etName)
        val etNotes: EditText = findViewById(R.id.etNotes)
        val btnOrder: Button = findViewById(R.id.btnOrder)

        etFoodName.text = foodName

        btnOrder.setOnClickListener {
            val servings = etServings.text.toString()
            val orderName = etName.text.toString()
            val notes = etNotes.text.toString()

            if (servings.isEmpty() || orderName.isEmpty()) {
                Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ConfirmationActivity::class.java)
                intent.putExtra("foodName", foodName)
                intent.putExtra("servings", servings)
                intent.putExtra("orderName", orderName)
                intent.putExtra("notes", notes)
                startActivity(intent)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
