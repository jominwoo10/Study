using System;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Diagnostics; //Process Ŭ���� ���
using System.Collections; //ArrayList ���
using System.Threading; //������ ���

namespace B_ProcessView
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private Thread ProcessThread; // ���μ��� ��Ÿ���� ������
        Thread checkThread = null; //�ǽð� �ý��� ���� üũ

        private delegate void ProcessUpdateDelegate(); // ��������Ʈ ����
        private ProcessUpdateDelegate UpProc = null;

        private delegate void TotalUpdateDelegate(int m, int n); // ��������Ʈ ����
        private TotalUpdateDelegate OnTotal = null;

        private PerformanceCounter oCPU = new PerformanceCounter("Processor", "% Processor Time", "_Total");
        //�ý��� CPU ���� ī����

        private PerformanceCounter oMem = new PerformanceCounter("Memory", "% Committed Bytes In Use");
        //�ý��� Mem ���� ī����

        private PerformanceCounter pCPU = new PerformanceCounter();

        bool bExit = false; 
        int cp = 0;
        private void Form1_Load(object sender, EventArgs e)
        {
            ProcessView(); //���μ��� ���

            UpProc = new ProcessUpdateDelegate(ProcessView); //��������Ʈ�� ���� �޼��� �Է�

            OnTotal = new TotalUpdateDelegate(TotalView);

            ProcessThread = new Thread(ProcessUpdate); //������ �븮�ڿ� ���� �޼��� �Է�

            ProcessThread.Start(); //������ ����

            checkThread = new Thread(getCPU_Info); checkThread.Start();
        }
        private void ProcessUpdate()
        {
            try
            {
                while (true)
                {
                    var oldlist = new ArrayList();

                    foreach (var oldproc in Process.GetProcesses()) 
                    {
                        oldlist.Add(oldproc.Id.ToString());
                    }

                    Thread.Sleep(1000);
                    var newproc = Process.GetProcesses();

                    if (oldlist.Count != newproc.Length)
                    {
                        Invoke(UpProc); 
                        continue; 
                    }

                    int i = 0;

                    foreach (var rewproc in Process.GetProcesses())
                    {
                        if (oldlist[i++].ToString() != rewproc.Id.ToString())
                        {
                            Invoke(UpProc);
                            break;
                        }
                    }
                }
            }
            catch { }
        }

        private void ProcessView()
        {
            try
            {
                this.lvView.Items.Clear(); 
                cp = 0; 

                foreach (var proc in Process.GetProcesses())
                {
                    string[] str; 

                    try
                    { 
                        str = proc.TotalProcessorTime.ToString().Split(new Char[] { '.' });
                    }

                    catch 
                    { 
                        str = new string[] { "" }; 
                    }

                    var strArray = new string[] { proc.ProcessName.ToString(), proc.Id.ToString(), str[0], NumFormat(proc.WorkingSet64) };
                    var lvt = new ListViewItem(strArray);
                    this.lvView.Items.Add(lvt); 
                    cp++;
                }
            }
            catch { }

            this.tsslProcess.Text = "���μ��� : " + cp.ToString() + "��";
        }

        private void TotalView(int m, int n)
        {
            this.tsslCpu.Text = "CPU ���: " + m.ToString() + " %";
            this.tsslMem.Text = "���� �޸� : " + n.ToString() + " %"; 
        }

        private string NumFormat(long MemNum)
        { 
            MemNum = MemNum / 1024;
            return String.Format("{0:N}", MemNum) + " KB";
        }

        private void getCPU_Info()
        { 
            while (!bExit) 
            { 
                int iCPU = (int)oCPU.NextValue(); 
                int iMem = (int)oMem.NextValue(); 
                Invoke(OnTotal, iCPU, iMem); 
                Thread.Sleep(1000); 
            }
        }

        private void ProccessKill()
        {
            try
            {
                int PID = Convert.ToInt32(this.lvView.SelectedItems[0].SubItems[1].Text); Process tProcess = Process.GetProcessById(PID); if (!(tProcess == null))
                {
                    var dlr = MessageBox.Show(this.lvView.SelectedItems[0].SubItems[0].Text + " ���μ����� �����ðڽ��ϱ�?", "�˸�", MessageBoxButtons.YesNo, MessageBoxIcon.Warning); 
                    
                    if (dlr == DialogResult.Yes) 
                    { 
                        tProcess.Kill();
                        ProcessView();
                    }
                }
                else
                {
                    MessageBox.Show(this.lvView.SelectedItems[0].SubItems[0].Text + "���μ����� �������� �ʽ��ϴ�", "�˸�", MessageBoxButtons.OK, MessageBoxIcon.Error); 
                    ProcessView();
                }
            }
            catch
            { 
                return; 
            }
        }

        private void btnKill_Click(object sender, EventArgs e)
        {
            ProccessKill();
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (!(ProcessThread == null))
                
                ProcessThread.Abort(); //������ ����
                

            if (!(checkThread == null))
                #pragma warning disable SYSLIB0006
                checkThread.Abort(); //������ ����
               
        }


    }
}