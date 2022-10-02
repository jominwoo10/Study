namespace B_FontControl
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void rtbText_TextChanged(object sender, EventArgs e)
        {

        }

        private void tsbtnFont_Click(object sender, EventArgs e)
        {
            if (this.fontDlg.ShowDialog() == DialogResult.OK)
            {
                this.rtbText.SelectionFont = fontDlg.Font;
            }
        }

        private void tsbtnColor_Click(object sender, EventArgs e)
        {
            if (this.colorDlg.ShowDialog() == DialogResult.OK)
            {
                this.rtbText.SelectionColor = colorDlg.Color;
            }
        }
    }
}