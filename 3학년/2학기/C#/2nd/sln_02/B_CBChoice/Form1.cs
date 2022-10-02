namespace B_CBChoice
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        string[] SList = new string[] { "스테이크", "카레라이스", "라면", "만두국", "김밥" }; //초기 콤보박스 데이터 설정
        string orgStr = ""; //선택 결과 저장
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
                MessageBox.Show("아이템을 추가하였습니다.", "알림", MessageBoxButtons.OK, MessageBoxIcon.Information);
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