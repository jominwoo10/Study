namespace B_FormView
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnModal_Click(object sender, EventArgs e)
        {
            Form2 frm2 = new Form2();
            frm2.SetText = this.btnModal.Text + " ����"; 
            frm2.ShowDialog(); // ��� �ɼ����� ������
        }

        private void btnModaless_Click(object sender, EventArgs e)
        {
            Form3 frm3 = new Form3();
            frm3.SetText = this.btnModaless.Text + " ����"; 
            frm3.Show(); 
            // ��޸��� �ɼ����� �� ��
        }
    }
}