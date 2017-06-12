namespace Ds.DataAccess.EF
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;

    public partial class dsStaffModel : DbContext
    {
        public dsStaffModel()
            : base("name=dsStaffModel")
        {
        }

        public virtual DbSet<ds_loainhanvien> ds_loainhanvien { get; set; }
        public virtual DbSet<ds_nhanvien> ds_nhanvien { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<ds_nhanvien>()
                .Property(e => e.ma_nv)
                .IsUnicode(false);

            modelBuilder.Entity<ds_nhanvien>()
                .Property(e => e.gioitinh)
                .IsFixedLength();
        }
    }
}
