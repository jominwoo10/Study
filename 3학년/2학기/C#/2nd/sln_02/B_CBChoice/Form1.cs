namespace B_CBChoice
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        string[] SList = new string[] { "������ũ", "ī�����̽�", "���", "���α�", "���" }; //�ʱ� �޺��ڽ� ������ ����
        string orgStr = ""; //���� ��� ����
        private void Form1_Load(object sender, EventArgs e)
        {
            for(int i = 0; i < SList.Length; i++)
            {
                this.cbList.Items.Add(SList[i]);
            }
            orgStr = this.lblResult.Text;
        }
 
        private void txtList_TextChanged(object sender, EventArgs e)
        {
            
        }

        private void btnAdd_Click_1(object sender, EventArgs e)
        {
            if (this.txtList.Text != "")
            {
                this.cbList.Items.Add(this.txtList.Text);
                MessageBox.Show("�������� �߰��Ͽ����ϴ�.", "�˸�", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
                this.txtList.Focus();
            this.txtList.Text = "";
        }

        private void cbList_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.cbList.Text != "")
                this.lblResult.Text = orgStr + this.cbList.Text;
        }
    }
}