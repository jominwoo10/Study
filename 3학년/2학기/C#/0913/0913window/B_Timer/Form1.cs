using Microsoft.VisualBasic;

namespace B_Timer
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        int CountOrgNum = 0;// �ʱ� ī����
        private void btnCount_Click(object sender, EventArgs e)
        {
            if (IntCheck() == true)
            {
                CountOrgNum = Convert.ToInt32(this.txtNum.Text);
                this.txtNum.ReadOnly = true;
                this.Timer.Enabled = true;
            }
        }

        private bool IntCheck()
        {
            if (Information.IsNumeric(this.txtNum.Text))
                return true;
            else
            {
                MessageBox.Show("���ڸ� �Է��ϼ���", "�˸�", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
        }

        private void Timer_Tick(object sender, EventArgs e)
        {
            if(CountOrgNum < 1)
            {
                this.Timer.Enabled = false; 
                this.txtNum.ReadOnly = false; 
                this.txtNum.Text = ""; 
                MessageBox.Show("��", "�˸�", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
            { 
                CountOrgNum--; 
                this.txtCountDown.Text = Convert.ToString(CountOrgNum);
            }
        }
    }
}