using System.Windows.Forms.VisualStyles;

namespace B_ListBox
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        string OrgStr = ""; //��� : ����

        private void Form1_Load(object sender, EventArgs e)
        {
            OrgStr = this.lblResult.Text;
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            if (this.txtList.Text != "")
            {
                this.lbView.Items.Add(this.txtList.Text);
                this.txtList.Text = "";
            }
            else
            {
                MessageBox.Show("�������� �Է��ϼ���", "�˸�", MessageBoxButtons.OK, MessageBoxIcon.Error);
                this.txtList.Focus();
            }
        }

        private void lbView_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.lbView.SelectedIndex != -1)
                this.lblResult.Text = OrgStr + this.lbView.SelectedItem.ToString();
            
            else
                this.lblResult.Text = OrgStr;
            
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            this.lbView.Items.Remove(lbView.Text);
            this.lblResult.Text = "��� : ";
            this.lbView.SelectedIndex = -1;
        }
    }
}