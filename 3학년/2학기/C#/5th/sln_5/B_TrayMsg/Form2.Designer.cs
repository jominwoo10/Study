﻿namespace B_TrayMsg
{
    partial class Form2
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.plBack = new System.Windows.Forms.Panel();
            this.lblResult = new System.Windows.Forms.LinkLabel();
            this.plBack.SuspendLayout();
            this.SuspendLayout();
            // 
            // plBack
            // 
            this.plBack.BackColor = System.Drawing.Color.LightBlue;
            this.plBack.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.plBack.Controls.Add(this.lblResult);
            this.plBack.Dock = System.Windows.Forms.DockStyle.Fill;
            this.plBack.Location = new System.Drawing.Point(0, 0);
            this.plBack.Name = "plBack";
            this.plBack.Size = new System.Drawing.Size(170, 120);
            this.plBack.TabIndex = 0;
            // 
            // lblResult
            // 
            this.lblResult.AutoSize = true;
            this.lblResult.Font = new System.Drawing.Font("맑은 고딕", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.lblResult.Location = new System.Drawing.Point(36, 45);
            this.lblResult.Name = "lblResult";
            this.lblResult.Size = new System.Drawing.Size(55, 30);
            this.lblResult.TabIndex = 0;
            this.lblResult.TabStop = true;
            this.lblResult.Text = "결과";
            this.lblResult.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(170, 120);
            this.Controls.Add(this.plBack);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Form2";
            this.ShowIcon = false;
            this.ShowInTaskbar = false;
            this.Text = "메시지 창";
            this.TopMost = true;
            this.Load += new System.EventHandler(this.Form2_Load);
            this.plBack.ResumeLayout(false);
            this.plBack.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private Panel plBack;
        private LinkLabel lblResult;
    }
}