using NUnit.Framework;
using Aloha;

namespace Tests
{
    public class Tests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void Test1()
        {
            Assert.Pass();
        }

        [TestCase(true)]
        [TestCase(false)]
        public void TestBoolMethod(bool input)
        {
            var output = Program.BoolMethod(input);
            Assert.That(output, Is.EqualTo(input));
        }
    }
}