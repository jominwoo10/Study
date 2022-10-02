namespace B_RBMsg
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        MessageBoxButtons mbb;
        MessageBoxIcon mbi;

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void radioButton3_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void gbOption1_Enter(object sender, EventArgs e)
        {

        }

  

        private void btnShow_Click_1(object sender, EventArgs e)
        {
            if (this.rbOK.Checked == true)
                mbb = MessageBoxButtons.OK;
            else if (this.rbOKCancel.Checked == true)
                mbb = MessageBoxButtons.OKCancel;
            else if (this.rbYesNo.Checked == true)
                mbb = MessageBoxButtons.YesNo;

            if (this.rbError.Checked == true)
                mbi = MessageBoxIcon.Error;
            else if (this.rbInformation.Checked == true)
                mbi = MessageBoxIcon.Information;
            else if (this.rbQuestion.Checked == true)
                mbi = MessageBoxIcon.Question;

            MessageBox.Show("메시지 박스를 확인하세요.", "알림", mbb, mbi);
        }
    }
}