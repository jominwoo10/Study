namespace B_TrayMsg
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnMsg_Click(object sender, EventArgs e)
        {
            Form2 frm2 = new Form2(); //Form2�� frm2 ��ü ����
            frm2.MsgText = this.txtMsg.Text; 
            frm2.ShowDialog();           
        }
    }
}